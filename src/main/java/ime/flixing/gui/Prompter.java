package ime.flixing.gui;

import java.util.Scanner;

public class Prompter {


	public static final String readOpt() {
		
		String tempOpt = "";
		Scanner scanner = new Scanner(System.in);
		tempOpt =  scanner.nextLine();
		return tempOpt;
		
	}	

	public static final String readOptWithMsg(String msg) {
		
		String tempOpt = "";
		Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + msg + "\n");
		tempOpt =  scanner.nextLine();
		return tempOpt;
		
	}
	
	public static final void pressIntroToContinue(){
		
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tPress Enter to continue");
        scanner.nextLine();
        
    }
	
}
