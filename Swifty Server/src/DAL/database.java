package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
public class database {
	
		
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;

	  static final String DB_URL = "jdbc:mysql://localhost/swifty?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	  public void initConnection()
	  {
		try
		{
							
				connect = DriverManager.getConnection(DB_URL,USER,PASS);
				statement = connect.createStatement();
				System.out.println(" conn to DB created succ");							
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	  }
	  	  	  
	  public String recordMatch(int id)
	  {
		  String sql = " UPDATE `winrecord` SET `matchwon`= (SELECT `matchwon` FROM `winrecord` WHERE `player_id` = ?)+1 WHERE `player_id` = ?";
		  try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, id);
			if (preparedStatement.executeUpdate() > 0)
				System.out.print("succ");
			else {
				System.out.print("Failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return "";
	  }
	  
	  /**
	 * @param obj
	 * @return
	 */
	  public String set_registerPlayer(JSONObject obj)
	  {
		  String sql = "INSERT INTO `player`(`username`, `PASSWORD`, `hoten`, `gender`, `ngsinh`) VALUES (?,?,?,?,?)";
		  try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, obj.getString("Username"));
			preparedStatement.setString(2, obj.getString("Password"));
			preparedStatement.setString(3, obj.getString("FnameLname"));
			preparedStatement.setInt(4, obj.getInt("Gender"));
			preparedStatement.setString(5, obj.getString("Birthday"));
			
			if(preparedStatement.executeUpdate() > 0)
			{				
				System.out.println("Succ");
				String sql2 = "Select player_id from player where `username` = ?";
				preparedStatement = connect.prepareStatement(sql2);
				preparedStatement.setString(1, obj.getString("Username"));			
				resultSet = preparedStatement.executeQuery();
				resultSet.next(); int id = resultSet.getInt("player_id");				
				sql2 = "INSERT INTO `winrecord`(`player_id`,`matchwon`) VALUES (?,0)";
				preparedStatement = connect.prepareStatement(sql2);
				preparedStatement.setInt(1, id);				
				if(preparedStatement.executeUpdate() > 0)
					return "\"Error code:\" \"Er3\""; //Unable to insert new player into record table
				return "\"Error code:\" \"Er0\"";
			}
			else 
				{
					resultSet = preparedStatement.getResultSet();
					String temp = "";
					while(resultSet.next())
					{
						temp += resultSet.getString(0);
					}
					System.out.println();
					System.out.println("Failed to register user profile");
					return "\"Error code:\" \"Er1\"";
				}
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "\"Error code:\" \"Er2\""; // Er2 = Unknown bug
		}
	  }
	  
	  public String get_rankingArray()
	  {
		  String result = "{\n"
		  			+"\"Status\": \"Failed\",\n"
		  			+"\"Error code\": \"Er1\",\n"
					+"\"Type\": \"Player List\",\n" 
					+"\"Player\":[\"???\",\"???\",\"???\",\"???\"]\n" 
					+"}";
		  try {
				String sql = "Select * from player,winrecord where player.player_id = winrecord.player_id order by winrecord.matchwon DESC";
				resultSet = statement.executeQuery(sql);
				result ="{\n"
						+"\"Status\": \"Success\",\n"
			  			+"\"Error code\": \"Er0\",\n"
						+"\"Type\": \"Player List\",\n" 
						+"\"Player\": [";
				List<String> playerlist = new ArrayList<String>();
				while(resultSet.next())
				{									
					playerlist.add(resultSet.getString("username"));
				}
				for(int i = 0; i<playerlist.size()-1; i++)
				{
					result +="\""+playerlist.get(i)+"\",";
				}
				result += "\""+playerlist.get(playerlist.size()-1)+"\"]\n}";
				System.out.print(result);
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				return result;
			}
	  }
	  
	  public String get_playerArray()
	  {
		  String result = "{\n"
		  			+"\"Status\": \"Failed\",\n"
		  			+"\"Error code\": \"Er1\",\n"
					+"\"Type\": \"Player List\",\n" 
					+"\"Player\":[\"???\",\"???\",\"???\",\"???\"]\n" 
					+"}";
		  try {
				String sql = "Select * from player";
				resultSet = statement.executeQuery(sql);
				result ="{\n"
						+"\"Status\": \"Success\",\n"
			  			+"\"Error code\": \"Er0\",\n"
						+"\"Type\": \"Player List\",\n" 
						+"\"Player\": [";
				List<String> playerlist = new ArrayList<String>();
				while(resultSet.next())
				{									
					playerlist.add(resultSet.getString("username"));
				}
				for(int i = 0; i<playerlist.size()-1; i++)
				{
					result +="\""+playerlist.get(i)+"\",";
				}
				result += "\""+playerlist.get(playerlist.size()-1)+"\"]\n}";
				System.out.print(result);
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				return result;
			}
	  }
	  
	  public void set_aPlayerInfo(JSONObject obj)
	  {
		  try {
			String sql = "UPDATE `player` SET `username`="+obj.getString("Username")
					  +",`PASSWORD`="+obj.getString("Password")
					  +",`hoten`="+obj.getString("FnameLname")
					  + ",`gender`="+obj.getString("Gender")
					  + ",`ngsinh`="+obj.getString("Birthday")
					  + "WHERE player_id =\""+obj.getString("Player ID");
			if(statement.execute(sql))
				System.out.println("Succ");
			else System.out.println("Failed to update user profile");
		} catch (JSONException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }	  
	  
	  public String get_aPlayerInfo(String id)
	  {		  
		  String result = "Er1"; // Er1 = cannot get setting from db
		  try {		 
			 String sql = "SELECT * FROM player WHERE player_id = ?";
			 preparedStatement = connect.prepareStatement(sql);
			 preparedStatement.setInt(1, Integer.parseInt(id));
			 if(!preparedStatement.execute())
			 {
				 System.out.println("broke");
			 }
			 resultSet = preparedStatement.executeQuery();	
			 resultSet = preparedStatement.getResultSet();
			 System.out.println(resultSet.toString());
			 
			 while(resultSet.next())
			 {				
				 result ="{\n"
						+ "\"Type\": \"Signin\",\n"				 		
				 		+ "\"Errorcode\": \"Er0\",\n"
				 		+ "\"player ID\": \""+resultSet.getString("player_id")+"\",\n"				 		
				 		+ "\"Username\": \""+resultSet.getString("username")+"\",\n"
				 		+ "\"Password\": \""+resultSet.getString("PASSWORD")+"\",\n"
				 		+ "\"FnameLname\": \""+resultSet.getString("hoten")+"\",\n"
				 		+ "\"Gender\": "+resultSet.getString("gender")+"\n"
				 		+ "\"Birthday\": \""+resultSet.getString("ngsinh")+"\"\n"
				 		+ "}";
			 }
			 System.out.println(result);
			 return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		} 
		  
	  }
	  
	  public String get_matchSetting()
	  {
		  String result = "{\n"				 		
			 			+ "\"Status\": \"Failed\"\n"
			 			+ "\"Errorcode\": \"Er1\"\n"// Er1 = cannot get setting from db
			 			+ "\"Time\": \"\",n"
			 			+ "\"fieldSize\": \"\",n"
			 			+ "\"SpedupNum\": [0,-1]"
			 			+ "}"; 
		  try {
			 String difficulty = "normal";			 
			 //difficulty = updatediff(); --To do later
			 String sql = "SELECT * FROM server_config WHERE config_id = ?";
			 //String sql = "SELECT * FROM SERVER_CONFIG";
			 preparedStatement = connect.prepareStatement(sql);
			 preparedStatement.setString(1, difficulty);			 
			 if(!preparedStatement.execute())
			 {
				 System.out.println("broke");
			 }
			 resultSet = preparedStatement.executeQuery();			 			 
			 while(resultSet.next())
			 {				
				 result ="{\n"				 		
				 		+ "\"Status\": \"Success\"\n"
				 		+ "\"Errorcode\": \"Er0\"\n"
				 		+ "\"Time\": "+resultSet.getString("time")+",\n"
				 		+ "\"fieldSize\": ["+resultSet.getString("size_x")+","+resultSet.getString("size_y")+"]\n"
				 		+ BUS.Miscellaneous.randomBonus(Integer.parseInt(resultSet.getString("size_x"))*Integer.parseInt(resultSet.getString("size_y")),1)+"\n"
				 		+ "}";
			 }
			 System.out.println(result);
			 return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		} 
	  }
	  private void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	
}