package BUS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Miscellaneous {
	static public String randomBonus(int up, int down)
	{
		HashMap mappu = new HashMap();
		String temp;
		int i = 0;
		while(i<5)
		{
			temp = RandomwRange(up,down);
			if(!mappu.containsKey(temp))
				mappu.put(temp, 1);
			i++;
		}
		temp = "\"SpedupNum\": [";
		for ( var j :mappu.keySet())
		{
			temp += j+",";
		}
		temp += RandomwRange(up,down)+"]";
		return temp;
	}
	static String RandomwRange(int up, int down) 
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(up) + down;
		return Integer.toString(randomInt);
	}
	static public String updateDiff()
	{
		try {
			FileReader in = new FileReader("Diff.txt");			
			BufferedReader br = new BufferedReader(in);
			String temp=null,diff=null;
			while((temp = br.readLine()) != null)
			{
				diff=temp;
			}
			return diff;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "normal";
	}
}
