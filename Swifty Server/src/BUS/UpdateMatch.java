package BUS;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateMatch {
	static public String S_updateMatch(JSONObject obj)
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
	static public String R_updateMatch()
	{
		return "";
	}
}
