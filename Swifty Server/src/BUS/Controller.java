package BUS;

import org.json.JSONException;
import org.json.JSONObject;

import DAL.database;

public class Controller {
	
	static public String Enroute(JSONObject obj, database a)
	{
		try {
			switch(obj.getString("Type"))
			{
				case "Signin": return a.get_aPlayerInfo(obj.getString("username"));
				case "Signup": return a.set_registerPlayer(obj);			
				case "Win": return a.recordMatch(obj.getInt("player ID"));				
				case "Ranking Request": return a.get_rankingArray();
				case "Player List Request": return a.get_playerArray();		
				//case "Quit": return cleanupRoom(); -- To do later
				//case "Logout": return cleanupLobby(); -- To do later
				//case "Create room": return createRoom(); -- To do later
				//case "Join room": return joinRoom(); -- To do later
			}
			return "Er4"; // Er4 = Controller error
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Er4"; 
		}
	}

}
