package ut.javafx.app.typing.test;

import java.util.Random;

public class CharProducer {
	
	private static char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 
			'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z'};
	
	public static String getRandomChar() {		
		return chars[new Random().nextInt(chars.length -1)] + "";		
	}
	
	public static int getInputSize() {
		return chars.length;
	}

}
