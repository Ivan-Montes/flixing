package ime.flixing.gui.submenu;

import ime.flixing.gui.Checker;
import ime.flixing.gui.DecoHelper;
import ime.flixing.gui.Prompter;

import java.util.List;

import ime.flixing.dao.PositionDao;
import ime.flixing.dao.impl.PositionDaoImpl;
import ime.flixing.entity.Position;

public class PositionGui {
	
	public void init() {
		
		boolean sentry = true;
		String selectedOption = "";
		
		while(sentry) {

				menuOptions();

				System.out.print(DecoHelper.MSG_VOLVER);
				
				selectedOption = Prompter.readOpt();
						
				 switch(selectedOption){
				 
		             case "1":
		            	 getAllPositionOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "2":
		            	 getPositionByIdOption();  
		            	 Prompter.pressIntroToContinue();          	 
		                 break;
		                 
		             case "3":
		            	 savePositionOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "4":
		            	 updatePositionOption();
		            	 Prompter.pressIntroToContinue();
		                 break;

		             case "5":
		            	 deletePositionOption();
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
		System.out.println("\t Options Position");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t1. getAllPosition");
	    System.out.println("\t2. getPositionById");
	    System.out.println("\t3. savePosition");
	    System.out.println("\t4. updatePosition");
	    System.out.println("\t5. deletePosition");  
	    System.out.println("\t0. Back");  
		System.out.println("\n");   
	    
	}
	
	private void getAllPositionOption() {
		
		PositionDao positionDao = new PositionDaoImpl();
		List<Position>list = positionDao.getAllPosition();
		list.forEach(System.out::println);
		
	}
	
	private void getPositionByIdOption() {
		
		String cod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(cod) ) {
			PositionDao positionDao = new PositionDaoImpl();
			Position position = positionDao.getPositionById(Long.parseLong(cod));
			
			if ( position != null) {				
				
				System.out.println(position);

			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}
			
		}else {
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
		}
	}
	
	private void savePositionOption() {
		
		String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NAME);
		String description = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_DESCRIPTION);
		
		if( Checker.checkName(name) && Checker.checkDescription(description) ) {

			PositionDao positionDao = new PositionDaoImpl();
			List<Position>list = positionDao.getPositionByNameId(name);
			
			if( list.isEmpty() ) {
				
				Position position = new Position();
				position.setName(name);
				position.setDescription(description);
				Position positionSaved = positionDao.savePosition(position);
				System.out.println(positionSaved);
				
			}else {
				System.out.println("\t" + DecoHelper.MSG_DUPLICATED_NAME);	
			}
			
		}else {
			System.out.println("\t" + DecoHelper.MSG_DATA_ERROR);
		}
	}
	
	private void updatePositionOption() {
		
		String positionCode = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);

		if ( Checker.checkDigits(positionCode) ) {
			
			PositionDao positionDao = new PositionDaoImpl();
			Position positionFound = positionDao.getPositionById(Long.parseLong(positionCode));
			
			if ( positionFound != null ) {
				
				System.out.println(positionFound);
				String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NEWNAME);
				String description = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NEWDESCRIPTION);
				
				if( Checker.checkName(name) && Checker.checkDescription(description) ) {
					
					List<Position>list = positionDao.getPositionByNameId(name);
					
					if ( list.isEmpty() ) {
						
						Position position = new Position();
						position.setName(name);
						position.setDescription(description);
						Position positionSaved = positionDao.updatePosition( Long.parseLong(positionCode), position );
						System.out.println(positionSaved);	
						
					}else {
						System.out.println("\t" + DecoHelper.MSG_DUPLICATED_NAME);	
					}
					
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
	
	private void deletePositionOption() {
		
		String positionCode = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(positionCode) ) {
			
			PositionDao positionDao = new PositionDaoImpl();
			Position positionFound = positionDao.getPositionByIdEagger(Long.parseLong(positionCode));
			
			if ( positionFound != null ) {
				
				System.out.println(positionFound);
				
				if ( Checker.checkConfirmation( Prompter.askConfirmation() ) ) {
					
					if ( positionFound.getFlixPersonPosition().isEmpty() ) {
						
						positionDao.deletePosition( Long.parseLong(positionCode) );
						System.out.println(DecoHelper.MSG_SUCCESSFULLY);
						
					}
					else {
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
