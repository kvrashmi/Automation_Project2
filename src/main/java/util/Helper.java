package util;

import java.util.Random;

public class Helper {
	
	public static int generateRandomNumber(int boundaryNum)
	{
		Random r=new Random();
		return r.nextInt(boundaryNum);
	}

}
