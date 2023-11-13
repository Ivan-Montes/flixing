package ime.flixing.gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

	
	public static final boolean checkDigits(String n) {	
		return ( n.matches("\\d+") );
	}

	public static final boolean checkFlixTitle(String n) {
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s\\-&\\?\\¿\\!\\¡]+");
		Matcher matcher = pattern.matcher(n);
		
		return matcher.matches() && (n.length() >= 1 && n.length() <= 50);
		
	}

	
}
