package ime.flixing.gui;

import java.util.Scanner;

import ime.flixing.tool.DecoHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor( access= AccessLevel.PRIVATE )
public class Prompter {


	public static final String readOpt() {
		
		Scanner scanner = new Scanner(System.in);
		return  scanner.nextLine();
		
	}	

	public static final String readOptWithMsg(String msg) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + msg + "\n");
		return scanner.nextLine();
		
	}
	

	public static final String askConfirmation() {
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + DecoHelper.MSG_ASK_CONFIRMATION + "\n");
		return scanner.nextLine();
		
	}
	public static final void pressIntroToContinue(){
		
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tPress Enter to continue");
        scanner.nextLine();
        
    }
	
}
