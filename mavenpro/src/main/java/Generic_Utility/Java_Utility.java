package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method is used to avoid Duplicates
	 * 
	 * @return
	 * @author Shobha
	 */
	public int getRandomValue() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;

	}

}
