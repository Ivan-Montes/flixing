package ime.flixing.gui.submenu;

import ime.flixing.gui.DecoHelper;
import ime.flixing.gui.Prompter;

public class PersonGui {

	
public void init() {
		
		boolean sentry = true;
		String selectedOption = "";
		
		while(sentry) {

				menuOptions();

				System.out.print(DecoHelper.MSG_VOLVER);
				
				selectedOption = Prompter.readOpt();
						
				 switch(selectedOption){
				 
		             case "1":
		            	 getAllPersonOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "2":
		            	 getPersonByIdOption();  
		            	 Prompter.pressIntroToContinue();          	 
		                 break;
		                 
		             case "3":
		            	 savePersonOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "4":
		            	 updatePersonOption();
		            	 Prompter.pressIntroToContinue();
		                 break;

		             case "5":
		            	 deletePersonOption();
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
		System.out.println("\t Options Person");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t1. getAllPerson");
	    System.out.println("\t2. getPersonById");
	    System.out.println("\t3. savePerson");
	    System.out.println("\t4. updatePerson");
	    System.out.println("\t5. deletePerson");  
	    System.out.println("\t0. Back");  
		System.out.println("\n");   
	    
	}
	
	private void getAllPersonOption() {
		
	}
	
	private void getPersonByIdOption() {
		
	}
	
	private void savePersonOption() {
		
	}
	
	private void updatePersonOption() {
		
		
	}
	
	private void deletePersonOption() {
		
	}
}
