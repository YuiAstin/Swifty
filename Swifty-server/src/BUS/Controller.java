package BUS;


import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;



import org.json.JSONException;
import org.json.JSONObject;

import DAL.database;

import main.server;

public class Controller {
	
	static public String Enroute(JSONObject obj, database a, DataOutputStream dos) throws IOException
	{
		try {
			switch(obj.getString("Type"))
			{
//				case "Signin": return a.get_aPlayerInfo(obj.getString("username"));
				case "Signin": return a.signin(obj.getString("Username"), obj.getString("Password"), dos);
				case "Signup": return a.set_registerPlayer(obj);
				case "EditProfile": return a.set_aPlayerInfo(obj);
				case "Win": return a.recordMatch(obj.getInt("player ID"));
				case "Ranking Request": return a.get_rankingArray();
				case "Player List Request": return a.get_playerArray();
				case "Online List Request": return onlineList(a);
				case "Quit": return cleanupRoom(obj); // Out room
				case "Logout": return cleanupLobby(obj); // Logout
				case "Create room": return createRoom(obj);
				case "Join room": return joinRoom(obj,a); // Quick match -- Create new room if no empty room
				case "MatchUpdate": return UpdateMatch.R_updateMatch(obj, a);
				case "StartGame": return StartGame(obj,a);
				case "EndGame": return EndGame(obj,a);
			}
			return "Er4"; // Er4 = Controller error
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Er4"; 
		}
	}

	private static String onlineList(database a) throws JSONException {
		// TODO Auto-generated method stub
		String s ="{\n"
				+"\"Status\": \"Success\",\n"
	  			+"\"Error code\": \"Er0\",\n"
				+"\"Type\": \"Online List\",\n";
		ArrayList<String> players = new ArrayList<String>(); // List all player in room
		for (Entry<String, Integer> lobby : server.Lobby.entrySet()) {
			String playerID = lobby.getKey();
			JSONObject obj = new JSONObject(a.get_aPlayerInfo(playerID));
			String uname = obj.getString("Username");
			players.add(uname);
		}
		String unames = String.join("\",\"", players);
		s += "\"Player\": [\""+ unames +"\"]\n}";
		return s;
	}

	private static String EndGame(JSONObject obj, database a) throws JSONException, IOException {
		// TODO Auto-generated method stub
		String PlayerID = obj.getInt("player ID")+"";
		int roomID = server.Lobby.get(PlayerID);
		String Player2ID = "";
		String Winner ="";
		int point = -1;
		String matchResult = "Win";
		
		if (obj.getString("reason").equals("Quit")) server.Point.replace(PlayerID,-9999);
		
		for (Entry<String, Integer> lobby : server.Lobby.entrySet()) {
			if (lobby.getValue() == roomID) {
				if (!lobby.getKey().equals(PlayerID)) Player2ID = lobby.getKey();
				server.Lobby.replace(lobby.getKey(), -1);
				int playerPoint = server.Point.get(lobby.getKey());
				if (playerPoint > point) {
					Winner = lobby.getKey();
					point = playerPoint;
				}
				else {
					if (playerPoint == point) {
						matchResult = "Tie";
					}
				}
			}
		}
		if (matchResult.equals("Win")) a.recordMatch(Integer.parseInt(Winner));
		String result ="{\n"
			    +"\"Type\": \"EndGame\",\n"
			    +"\"Errorcode\": \"Er0\",\n"
			    +"\"Result\": \""+matchResult+"\",\n"
				+"\"player ID\": \""+Winner+"\"\n" // Win player
				+"}";
		server.Player.get(Player2ID).writeUTF(result);
		return result;
	}

	private static String StartGame(JSONObject obj, database a) throws JSONException, IOException {
		// TODO Auto-generated method stub
		int player_id = obj.getInt("player ID");
		int room_id = server.Lobby.get(player_id+"");
		String player2ID = "";
		
		ArrayList<String> players = new ArrayList<String>(); // List all player in room
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {
			String Player_id = room.getKey();
			int number = room.getValue();
			if (number == room_id) { // Player in room 
				if (!Player_id.equals(player_id+"")) player2ID = Player_id;
				String json = a.get_aPlayerInfo(Player_id);
				JSONObject js = new JSONObject(json);
				String uname = js.getString("Username");
				players.add(uname);
				
				// Reset point
				server.Point.replace(Player_id, 0);
				
			}
		}
		
		String unames = String.join("\",\"", players);
		
		String s = a.get_matchSetting();

		// Add first number
		int range = 100;
		int first_number = (int)(Math.random() *range) + 1;
		// Save current FindingNumber
		if (server.Room.containsKey(room_id)) server.Room.replace(room_id, first_number);
		else server.Room.put(room_id, first_number);
		
		s += "\"TimeStart\": "+System.currentTimeMillis()+",\n";
		s += "\"NextNumber\": "+first_number+",\n";
		s += "\"Players\": [\""+ unames +"\"]\n}";
		server.Player.get(player2ID).writeUTF(s);
		
		
		
		return s;
	}

	private static String cleanupLobby(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		String playerID = obj.getString("player ID");
		if (server.Lobby.containsKey(playerID)) {
			server.Lobby.remove(playerID);
		}
		if (server.Player.containsKey(playerID)) {
			server.Player.remove(playerID);
		}
		
		return "\"Error code:\" \"Er0\"";
	}

	private static String cleanupRoom(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		String playerID = obj.getString("player ID");
		if (server.Lobby.containsKey(playerID)) {
			server.Lobby.replace(playerID, -1);
		}
		return "\"Error code:\" \"Er0\"";
	}

	private static String joinRoom(JSONObject obj, database a) throws JSONException, IOException {
		// TODO Auto-generated method stub
		int max_player = 2;
		String player_id = obj.getString("player ID");
		HashMap<Integer,Integer> rooms = new HashMap<Integer,Integer>();
		
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {
	          int number = room.getValue();
	          if (rooms.get(number) == null) rooms.put(number, 1);
	          else rooms.put(number, rooms.get(number)+1);
        }

		for (Entry<Integer, Integer> room : rooms.entrySet()) {
			int room_id =  room.getKey();
			int number = room.getValue();
			if (room_id >-1 && number < max_player) {
				
				
				String player1_id = "";
				for (Entry<String, Integer> lobby : server.Lobby.entrySet()) { // Get player 1 ID
			          if (room_id == lobby.getValue()) {
			        	  player1_id = lobby.getKey();
			          }
		        }
				
				server.Lobby.put(player_id, room_id); // Put player 2 into room
				
				JSONObject obj1 = new JSONObject(a.get_aPlayerInfo(player1_id));
				JSONObject obj2 = new JSONObject(a.get_aPlayerInfo(player_id));
				String result ="{\n"
					    +"\"Type\": \"JoinRoom\",\n"
					    +"\"Errorcode\": \"Er0\",\n"
						+"\"player1 Name\": "+obj1.getString("Username")+",\n"
						+"\"player2 Name\": "+obj2.getString("Username")+",\n"
						+"\"room ID\": "+room_id+"\n"
					+"}";
				
				server.Player.get(player1_id).writeUTF(result); // Send info back to room master (player 1)
				return result;
			}
		}
		
		return createRoom(obj);
	}

	private static String createRoom(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		String result = "\"Error code:\" \"Er0\"";;

		for (int i=1;i<=server.Lobby.size()+1;i++) {
			if (server.Lobby.containsValue(i)) continue;
			else { // Put player int room
				server.Lobby.put(obj.getString("player ID"), i);
				result ="{\n"
					    +"\"Type\": \"CreateRoom\",\n"
					    +"\"Errorcode\": \"Er0\",\n"
						+"\"room ID\": "+i+"\n"
					+"}";
				
				if (obj.has("player2 ID") && !obj.getString("player2 ID").isEmpty()) { // This line is used for find room by id function
					server.Lobby.put(obj.getString("player2 ID"), i);
				}
				
				break;
			}
		}
		return result;
	}

}
