package ime.flixing.gui.submenu;

import java.util.List;

import ime.flixing.dao.GenreDao;
import ime.flixing.dao.impl.*;
import ime.flixing.entity.Genre;
import ime.flixing.gui.Prompter;
import ime.flixing.tool.Checker;
import ime.flixing.tool.DecoHelper;

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
		
		GenreDao genreDao = new GenreDaoImpl();
		List<Genre>list = genreDao.getAllGenre();
		list.forEach(System.out::println);
		
	}
	
	private void getGenreByIdOption() {
		
		String cod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(cod) ) {

			GenreDao genreDao = new GenreDaoImpl();
			Genre genre = genreDao.getGenreById( Long.parseLong(cod) );
			
			if ( genre != null) {				
				
				System.out.println(genre);

			}else {
				System.out.println("\t" + DecoHelper.MSG_NULL_ERROR);
			}
			
		}else {
			
			System.out.println("\t" + DecoHelper.MSG_COD_ERROR);
			
		}
	}
	
	private void saveGenreOption() {		
	
		String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NAME);
		String description = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_DESCRIPTION);
		
		if( Checker.checkName(name) && Checker.checkDescription(description) ) {
			
			GenreDao genreDao = new GenreDaoImpl();
			
			List<Genre>list = genreDao.getGenreByName(name);
			
			if ( list.isEmpty() ) {
				
				Genre genre = new Genre();
				genre.setName(name);
				genre.setDescription(description);
				Genre genreSaved = genreDao.saveGenre(genre);
				System.out.println(genreSaved);
				
			}else {
				System.out.println("\t" + DecoHelper.MSG_DUPLICATED_NAME);
			}		
			
		}else {
			System.out.println("\t" + DecoHelper.MSG_DATA_ERROR);
		}
	}
	
	private void updateGenreOption() {
	
	String genreCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);
		
		if ( Checker.checkDigits(genreCod) ) {
			
			GenreDao genreDao = new GenreDaoImpl();
			Genre genreFound = genreDao.getGenreById( Long.parseLong(genreCod) );
			
			if ( genreFound != null ) {
				
				System.out.println(genreFound);
				String name = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_NAME);
				String description = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_DESCRIPTION);
				
				if( Checker.checkName(name) && Checker.checkDescription(description) ) {
					
					List<Genre>list = genreDao.getGenreByName(name);
					
					if ( list.isEmpty() ) {
						Genre genre = new Genre();
						genre.setName(name);
						genre.setDescription(description);
						Genre genreSaved = genreDao.updateGenre( Long.parseLong(genreCod), genre);
						System.out.println(genreSaved);
						
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
	
	private void deleteGenreOption() {
		
		String genreCod = Prompter.readOptWithMsg(DecoHelper.MSG_WRITE_COD);

		if ( Checker.checkDigits(genreCod) ) {
			
			GenreDao genreDao = new GenreDaoImpl();
			Genre genreFound = genreDao.getGenreByIdEagger( Long.parseLong(genreCod) );
			
			if ( genreFound != null ) {
				
				System.out.println(genreFound);
				
				if ( Checker.checkConfirmation( Prompter.askConfirmation() ) ) {
				
						if ( genreFound.getFlixes().isEmpty() ) {
						
							genreDao.deleteGenre( Long.parseLong(genreCod) );
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
