package ime.flixing.gui.submenu;

import ime.flixing.gui.Prompter;
import ime.flixing.tool.Checker;
import ime.flixing.tool.DecoHelper;
import ime.flixing.dao.*;
import ime.flixing.dao.impl.*;
import ime.flixing.entity.Person;

import java.util.List;

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
		PersonDao personDao = new PersonDaoImpl();
		List<Person>list = personDao.getAllPerson();
		list.forEach(System.out::println);
	}
	
	private void getPersonByIdOption() {
		
		String cod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);

		if ( Checker.checkDigits(cod) ) {
			
			PersonDao personDao = new PersonDaoImpl();
			Person person = personDao.getPersonById(Long.parseLong(cod));
			
			if ( person != null) {				
				
				System.out.println(person);

			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}
			
		}else {			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);			
		}
	}
	
	private void savePersonOption() {
		
		String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NAME);
		String surname = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_SURNAME);
		
		if ( Checker.checkName(name) && Checker.checkSurname(surname) ) {
			
			PersonDao personDao = new PersonDaoImpl();
			Person person = new Person();
			person.setName(name);
			person.setSurname(surname);
			Person personSaved = personDao.savePerson(person);
			System.out.println(personSaved);
			
		}else {			
			System.out.println("\t" + DecoHelper.MSG_DATA_ERROR);
		}	
	}
	
	private void updatePersonOption() {
		
		String personCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(personCod) ) {
			PersonDao personDao = new PersonDaoImpl();
			Person personFound = personDao.getPersonById(Long.parseLong(personCod));
			
			if ( personFound != null ) {
				
				System.out.println(personFound);
				String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NAME);
				String surname = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_SURNAME);
				
				if ( Checker.checkName(name) && Checker.checkSurname(surname) ) {
					
					Person person = new Person();
					person.setName(name);
					person.setSurname(surname);
					Person personSaved = personDao.updatePerson(Long.parseLong(personCod), person);
					System.out.println(personSaved);

				}else {					
					System.out.println("\t" + DecoHelper.MSG_DATA_ERROR);
				}
				
			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}	
			
		}else {
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
		}	

	}
	
	private void deletePersonOption() {
		
		String personCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(personCod) ) {
			
			PersonDao personDao = new PersonDaoImpl();
			Person personFound = personDao.getPersonByIdEagger(Long.parseLong(personCod));
			
			if ( personFound != null ) {
				
				System.out.println(personFound);
				
				if ( Checker.checkConfirmation( Prompter.askConfirmation() ) ) {
					
						if ( personFound.getFlixPersonPosition().isEmpty() ) {
						
							personDao.deletePerson( Long.parseLong(personCod) );
							System.out.println(DecoHelper.MSG_SUCCESSFULLY);
						
						}else {							
							System.out.println("\t" + DecoHelper.MSG_ERROR_DELETE_ASSOCIATED_ITEMS);						
						}
				}				
			}else {				
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);				
			}			
		}else {			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);			
		}
	}
}
