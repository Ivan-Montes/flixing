package ime.flixing.gui.submenu;

import ime.flixing.gui.Checker;
import ime.flixing.gui.DecoHelper;
import ime.flixing.gui.Prompter;

import java.util.Arrays;
import java.util.List;

import ime.flixing.dao.*;
import ime.flixing.dao.impl.*;
import ime.flixing.entity.Flix;
import ime.flixing.entity.FlixPersonPosition;
import ime.flixing.entity.Person;
import ime.flixing.entity.Position;

public class FlixPersonPositionGui {

	

public void init() {
		
		boolean sentry = true;
		String selectedOption = "";
		
		while(sentry) {

				menuOptions();

				System.out.print(DecoHelper.MSG_VOLVER);
				
				selectedOption = Prompter.readOpt();
						
				 switch(selectedOption){
				 
		             case "1":
		            	 getAllFlixPersonPositionOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "2":
		            	 getFlixPersonPositionByIdOption();  
		            	 Prompter.pressIntroToContinue();          	 
		                 break;
		                 
		             case "3":
		            	 saveFlixPersonPositionOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "4":
		            	 deleteFlixPersonPositionOption();
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
		System.out.println("\t Options FlixPersonPosition");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t1. getAllFlixPersonPosition");
	    System.out.println("\t2. getFlixPersonPositionById");
	    System.out.println("\t3. saveFlixPersonPosition");
	    System.out.println("\t4. deleteFlixPersonPosition");
	    System.out.println("\t0. Back");  
		System.out.println("\n");   
	    
	}
	
	private void getAllFlixPersonPositionOption() {
		
		FlixPersonPositionDao flixPersonPositionDao = new FlixPersonPositionDaoImpl();
		List<FlixPersonPosition>list = flixPersonPositionDao.getAllFlixPersonPosition();
		list.forEach(System.out::println);
		
	}
	
	private void getFlixPersonPositionByIdOption() {
		
		String flixCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_FLIX);
		String personCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_PERSON);
		String positionCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_POSITION);
		
		if ( Checker.checkDigits(flixCod) && Checker.checkDigits(personCod) && Checker.checkDigits(positionCod)  ) {
			
			FlixPersonPositionDao flixPersonPositionDao = new FlixPersonPositionDaoImpl();
			FlixPersonPosition flixPersonPositionFound = flixPersonPositionDao.getFlixPersonPositionById(Long.parseLong(flixCod), 
																									Long.parseLong(personCod), 
																									Long.parseLong(positionCod) );
			if ( flixPersonPositionFound != null) {				
				
				System.out.println(flixPersonPositionFound);

			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}

		}else {
			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
			
		}
		
	}
	
	private void saveFlixPersonPositionOption() {
			
		String flixCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_FLIX);
		String personCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_PERSON);
		String positionCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_POSITION);
		
		List<Boolean>checkCodsList = Arrays.asList(Checker.checkDigits(flixCod),Checker.checkDigits(personCod),Checker.checkDigits(positionCod));
		
		if ( checkCodsList.stream().allMatch( b -> b.equals(true) ) ) {
			
			FlixDao flixDao = new FlixDaoImpl();
			Flix flixFound = flixDao.getFlixById(Long.parseLong(flixCod));
			
			PersonDao personDao = new PersonDaoImpl();
			Person personFound = personDao.getPersonById(Long.parseLong(personCod));			

			PositionDao positionDao = new PositionDaoImpl();
			Position positionFound = positionDao.getPositionById(Long.parseLong(positionCod));
			
			if ( flixFound != null && personFound != null && positionFound != null ) {
				
				FlixPersonPositionDao flixPersonPositionDao = new FlixPersonPositionDaoImpl();
				FlixPersonPosition flixPersonPositionFound = flixPersonPositionDao.getFlixPersonPositionById(Long.parseLong(flixCod), 
																											Long.parseLong(personCod), 
																											Long.parseLong(positionCod) );
				if( flixPersonPositionFound == null ) {
					
					FlixPersonPosition flixPersonPositionSaved = flixPersonPositionDao.saveFlixPersonPosition(Long.parseLong(flixCod), 
							Long.parseLong(personCod), 
							Long.parseLong(positionCod) );
					
					if ( flixPersonPositionSaved != null) {				
					
						System.out.println(flixPersonPositionSaved);
					
					}else {
						
						System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
					
					}

				}else {
					
					System.out.println("\t" + DecoHelper.MSG_REGISTRY_REPEATED);
					
				}
				
				
				
			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}			
			
		}else {
			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
			
		}
	}
	
	private void deleteFlixPersonPositionOption() {
		
		String flixCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_FLIX);
		String personCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_PERSON);
		String positionCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_POSITION);
		
		if ( Checker.checkDigits(flixCod) && Checker.checkDigits(personCod) && Checker.checkDigits(positionCod)  ) {
			
			FlixDao flixDao = new FlixDaoImpl();
			Flix flixFound = flixDao.getFlixById(Long.parseLong(flixCod));
			
			PersonDao personDao = new PersonDaoImpl();
			Person personFound = personDao.getPersonById(Long.parseLong(personCod));			

			PositionDao positionDao = new PositionDaoImpl();
			Position positionFound = positionDao.getPositionById(Long.parseLong(positionCod));
			
			if ( flixFound != null && personFound != null && positionFound != null ) {
				
				FlixPersonPositionDao flixPersonPositionDao = new FlixPersonPositionDaoImpl();
				FlixPersonPosition flixPersonPositionFound = flixPersonPositionDao.getFlixPersonPositionById(Long.parseLong(flixCod), 
																										Long.parseLong(personCod), 
																										Long.parseLong(positionCod) );
				
				if ( flixPersonPositionFound != null) {				
					
					flixPersonPositionDao.deleteFlixPersonPosition(Long.parseLong(flixCod), 
																	Long.parseLong(personCod), 
																	Long.parseLong(positionCod) );
					System.out.println(DecoHelper.MSG_SUCCESSFULLY);

				}else {
					System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
				}
				
			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}	
			
			
		}else {
			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
			
		}
	}
	
}
