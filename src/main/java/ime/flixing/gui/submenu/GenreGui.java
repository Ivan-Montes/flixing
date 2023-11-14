package ime.flixing.gui.submenu;

import ime.flixing.gui.DecoHelper;
import ime.flixing.gui.Prompter;

public class GenreGui {

	
public void init() {
		
		boolean sentry = true;
		String selectedOption = "";
		
		while(sentry) {

				menuOptions();

				System.out.print(DecoHelper.MSG_VOLVER);
				
				selectedOption = Prompter.readOpt();
						
				 switch(selectedOption){
				 
		             case "1":
		            	 getAllGenreOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "2":
		            	 getGenreByIdOption();  
		            	 Prompter.pressIntroToContinue();          	 
		                 break;
		                 
		             case "3":
		            	 saveGenreOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "4":
		            	 updateGenreOption();
		            	 Prompter.pressIntroToContinue();
		                 break;

		             case "5":
		            	 deleteGenreOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "0":		            	 
		                 sentry = false;
		                 break;
		
		             default:
		                 System.out.println("\n\t" + DecoHelper.MSG_OPTERROR);
		                 Prompter.pressIntroToContinue();
		         }
			}	
	}


	private void menuOptions() {
		
		System.out.println("\n");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t Options Genre");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t1. getAllGenre");
	    System.out.println("\t2. getGenreById");
	    System.out.println("\t3. saveGenre");
	    System.out.println("\t4. updateGenre");
	    System.out.println("\t5. deleteGenre");  
	    System.out.println("\t0. Back");  
		System.out.println("\n");   
	    
	}
	
	private void getAllGenreOption() {
		
	}
	
	private void getGenreByIdOption() {
		
	}
	
	private void saveGenreOption() {
		
	}
	
	private void updateGenreOption() {
		
		
	}
	
	private void deleteGenreOption() {
		
	}
}
