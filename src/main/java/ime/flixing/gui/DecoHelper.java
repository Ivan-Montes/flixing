package ime.flixing.gui;

import java.util.Collections;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DecoHelper {

	
	private static final String DECOTICONO_PRIME = "#";
	private static final String DECOTICONO_SECOND = "=";
	private static final Integer DECOTICONO_SIZE_MAIN = 33;
	
	private static final Supplier<String> supDecoPrime = () -> String.join("", Collections.nCopies(DECOTICONO_SIZE_MAIN, DECOTICONO_PRIME));
	private static final Supplier<String> supDecoSecond = () -> String.join("", Collections.nCopies(DECOTICONO_SIZE_MAIN, DECOTICONO_SECOND));

	public static final Runnable  runDecoPrime = () -> System.out.println(supDecoPrime.get());
	public static final Runnable  runDecoSecond = () -> System.out.println(supDecoSecond.get());
	
	Function<Integer, String> funcDeco = (n) -> String.join("", Collections.nCopies(n, DECOTICONO_PRIME));
	BiFunction<Integer, String, String> bifuDeco = (i,s) -> String.join("", Collections.nCopies(i, s));
	BiConsumer<Integer,String> biConDeco = (i,s) -> System.out.println(String.join("", Collections.nCopies(i, s)));
	
	public static final String MSG_VOLVER = "Enter option number (0 for back): ";
	public static final String MSG_SALIR = "Enter option number (0 for exit): ";
	public static final String MSG_NULL_ERROR = "Null object found";
	public static final String MSG_OPTERROR = "Wrong option";
	public static final String MSG_COD_ERROR = "Wrong code";
	public static final String MSG_DATA_ERROR = "Some data is Wrong";
	public static final String MSG_WRITE_COD = "Next, Write a valid code ";
	public static final String MSG_WRITE_COD_FLIX = "Please, Write a valid FLIX code ";
	public static final String MSG_WRITE_COD_PERSON = "Next, Write a valid PERSON code ";
	public static final String MSG_WRITE_COD_POSITION = "Now, Write a valid POSITION code ";
	public static final String MSG_WRITE_NAME = "Now, Write a name ";
	public static final String MSG_WRITE_SURNAME = "Now, Write a surname ";
	public static final String MSG_WRITE_COD_GENRE = "Please next Write a cod GENRE ";
	public static final String MSG_WRITE_DESCRIPTION = "Now, Write a description ";
	public static final String MSG_WRITE_NEWNAME = "Please now, Write a new name ";
	public static final String MSG_WRITE_NEWCOD_GENRE = "Write a new cod GENRE ";
	public static final String MSG_WRITE_NEWDESCRIPTION = "Now, Write a new description ";
	public static final String MSG_ASK_CONFIRMATION = "Enter Y/N to confirm: ";
	public static final String MSG_SUCCESSFULLY = "Process complete successfully";
	public static final String MSG_ERROR_DELETE_ASSOCIATED_ITEMS = "Some items are still associated to this entity. Impossible to delete. Please, first empty the list";
}
