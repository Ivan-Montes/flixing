package ime.flixing.gui;


import ime.flixing.gui.submenu.*;
import ime.flixing.tool.DecoHelper;

public class MainGui {	
	
	public void init() {

        boolean sentry = true;
        String selectedOption = "";
        
		menuWelcome();
		
		while(sentry) {

			menuOptionsMain();

			System.out.print(DecoHelper.MSG_SALIR);
			
			selectedOption = Prompter.readOpt();
					
			 switch(selectedOption){
			 
	             case "1":
	            	 new FlixGui().init();
	                 break;
	                 
	             case "2":
	            	 new GenreGui().init();        	 
	                 break;
	                 
	             case "3":
	            	 new PersonGui().init();
	                 break;
	                 
	             case "4":
	            	 new PositionGui().init();
	                 break;

	             case "5":
	            	 new FlixPersonPositionGui().init();
	                 break;
	                 
	             case "0":
	            	 menuBye();
	                 sentry = false;
	                 break;
	
	             default:
	                 System.out.println("\n\t" + DecoHelper.MSG_OPTERROR);
	                 Prompter.pressIntroToContinue();
	         }
		}		
	}
	
	private void menuWelcome() {
		
		DecoHelper.runDecoPrime.run();
		System.out.println("\t Welcome Flixing");
		DecoHelper.runDecoPrime.run();		
	}
	
	private void menuOptionsMain() {
		
		System.out.println("\n");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t Options Flixing");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t1. Flix");
        System.out.println("\t2. Genre");
        System.out.println("\t3. Person");
        System.out.println("\t4. Position");
        System.out.println("\t5. Flix-Person-Position");  
        System.out.println("\t0. Exit");  
		System.out.println("\n");   
        
	}
	
	private void menuBye() {
		
		System.out.println("\n");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t See you Later");
		DecoHelper.runDecoSecond.run();
		
	}
		        
}
