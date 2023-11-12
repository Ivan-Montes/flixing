package ime.flixing.gui;

import java.io.*;
import java.util.*;

import ime.flixing.gui.submenu.FlixGui;

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
	            	 Prompter.pressIntroToContinue();            	 
	                 break;
	                 
	             case "3":
	            	 Prompter.pressIntroToContinue();
	                 break;
	                 
	             case "4":
	            	 Prompter.pressIntroToContinue();
	                 break;

	             case "5":
	            	 Prompter.pressIntroToContinue();
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
	
	
	private String pedirNumero() {
		String leido = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String decoIgual = String.join("", Collections.nCopies(60, "=") );
		
		while(true) {
				
			try {
				System.out.println(decoIgual);
				System.out.print("Introduce el identificador a consultar (0 para salir):");
				leido = br.readLine();
				
				if(!leido.isEmpty() && leido.matches("\\d+") ) {
					break;
				}
				System.out.println("Error: Dato no válido");
				
			}catch(IOException e) {
				System.out.println("Error: Fallo al leer el dato escrito por consola");
				e.printStackTrace();
			}
		}		
		
		return leido;
	}
	
	    

        
        
}
