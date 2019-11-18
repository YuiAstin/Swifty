package DAL;

	import java.sql.*;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;
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
	  public String get_matchsetting()
	  {
		  String result = "Er1"; // Er1 = cannot get setting from db
		  try {
			 String difficulty = "hard";			 
			 //difficulty = updatediff(); --To do later
			 //String sql = "SELECT * FROM SERVER_CONFIG WHERE `CONFIG_ID` ='"+difficulty+"'";
			 String sql = "SELECT * FROM SERVER_CONFIG";
			 if(!statement.execute(sql))
			 {
				 System.out.println("broke");
			 }
			 resultSet = statement.executeQuery(sql);			 
			 System.out.println(resultSet.toString());
			 if(resultSet.isFirst())
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
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		  {
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
