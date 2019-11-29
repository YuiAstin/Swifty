package BUS;

import java.io.DataOutputStream;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import main.*;


public class BUS {

	public static void sendNumber(String a) {
		// TODO Auto-generated method stub
		try {
			String result ="{\n"
				    +"\"Type\": \"MatchUpdate\",\n"
					+"\"player ID\": "+main.Client.player.getString("player ID")+",\n"
				    +"\"fieldUpdate\": "+a+"\n"
				+"}";
			DataOutputStream dos = new DataOutputStream(main.Client.socket.getOutputStream());
			dos.writeUTF(result);
			
		} catch (JSONException |IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
