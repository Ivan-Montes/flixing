package ime.flixing.gui.submenu;

import java.util.List;

import ime.flixing.dao.*;
import ime.flixing.dao.impl.*;
import ime.flixing.entity.*;
import ime.flixing.gui.Checker;
import ime.flixing.gui.DecoHelper;
import ime.flixing.gui.Prompter;

public class FlixGui {

	public void init() {
		
		boolean sentry = true;
		String selectedOption = "";
		
		while(sentry) {

				menuOptions();

				System.out.print(DecoHelper.MSG_VOLVER);
				
				selectedOption = Prompter.readOpt();
						
				 switch(selectedOption){
				 
		             case "1":
		            	 getAllFlixOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "2":
		            	 getFlixByIdOption();  
		            	 Prompter.pressIntroToContinue();          	 
		                 break;
		                 
		             case "3":
		            	 saveFlixOption();
		            	 Prompter.pressIntroToContinue();
		                 break;
		                 
		             case "4":
		            	 updateFlixOption();
		            	 Prompter.pressIntroToContinue();
		                 break;

		             case "5":
		            	 deleteFlixOption();
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
		System.out.println("\t Options Flix");
		DecoHelper.runDecoSecond.run();
		System.out.println("\t1. getAllFlix");
        System.out.println("\t2. getFlixById");
        System.out.println("\t3. saveFlix");
        System.out.println("\t4. updateFlix");
        System.out.println("\t5. deleteFlix");  
        System.out.println("\t0. Back");  
		System.out.println("\n");   
        
	}
	
	private void getAllFlixOption() {
		FlixDao flixDaoImpl = new FlixDaoImpl();
		List<Flix> list = flixDaoImpl.getAllFlix();
		list.forEach(System.out::println);
	}

	private void getFlixByIdOption() {
		
		String cod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(cod) ) {
			
			FlixDao flixDaoImpl = new FlixDaoImpl();
			Flix flix = flixDaoImpl.getFlixById(Long.parseLong(cod));
			System.out.println(flix);
			
		}else {
			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
			
		}
		
	}

	private void saveFlixOption() {
		
		String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NAME);
		String genreCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD_GENRE);
		
		if ( Checker.checkFlixTitle(name) && Checker.checkDigits(genreCod) ) {
			GenreDao genreDaoImpl = new GenreDaoImpl();
			Genre genre = genreDaoImpl.getGenreById(Long.parseLong(genreCod));
			FlixDao flixDaoImpl = new FlixDaoImpl();
			Flix flix = new Flix();
			flix.setTitle(name);
			flix.setGenre(genre);
			Flix flixSaved = flixDaoImpl.saveFlix(flix);
			System.out.println(flixSaved);
			
		}else {
			System.out.println("\t" + DecoHelper.MSG_DATA_ERROR);
		}
				
	}

	private void updateFlixOption() {
		
		String flixCode = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(flixCode) ) {
			
			FlixDao flixDaoImpl = new FlixDaoImpl();
			Flix flixFound = flixDaoImpl.getFlixById(Long.parseLong(flixCode));
			
			if ( flixFound != null ) {
				
				System.out.println(flixFound);
				String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NEWNAME);
				String genreCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NEWCOD_GENRE);
				
				if ( Checker.checkFlixTitle(name) && Checker.checkDigits(genreCod) ) {
					
					GenreDao genreDaoImpl = new GenreDaoImpl();
					Genre genre = genreDaoImpl.getGenreById(Long.parseLong(genreCod));
					
					if ( genre != null ) {
						
						Flix flix = new Flix();
						flix.setTitle(name);
						flix.setGenre(genre);
						Flix flixSaved = flixDaoImpl.updateFlix(Long.parseLong(flixCode), flix);
						System.out.println(flixSaved);
						
					}else {
						System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
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

	private void deleteFlixOption() {
		
		String flixCode = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(flixCode) ) {
			
			FlixDao flixDaoImpl = new FlixDaoImpl();
			Flix flixFound = flixDaoImpl.getFlixByIdEagger(Long.parseLong(flixCode));
			
			if ( flixFound != null ) {
				
				System.out.println(flixFound);
				
				if ( Checker.checkConfirmation( Prompter.askConfirmation() ) ) {
					
					if ( flixFound.getFlixPersonPosition().isEmpty() ) {
						
						flixDaoImpl.deleteFlix( Long.parseLong(flixCode) );
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
