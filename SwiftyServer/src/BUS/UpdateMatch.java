package BUS;

import org.json.JSONException;
import org.json.JSONObject;

import DAL.database;

public class UpdateMatch {
	public String S_updateMatch(JSONObject obj)
	{		  
		String result="\"Error code\": \"Er2\",\n";
		try {
			result = "{/n"
					+ "\"Type\": \"MatchUdate\",\n"
					+ "\"fieldUpdate\": "+obj.getInt("fieldUpdate")+",\n";
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
	}
	public static String R_updateMatch(int id, database a)
	{
		String result="\"Error code\": \"Er2\",\n";
		
		
		return a.recordMatch(id);
	}
}
