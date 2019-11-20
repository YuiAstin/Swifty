package BUS;

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
}
