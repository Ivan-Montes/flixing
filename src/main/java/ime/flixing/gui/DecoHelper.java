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
	public static final String MSG_WRITE_COD = "Write a valid code ";
	public static final String MSG_WRITE_NAME = "Write a name ";
	public static final String MSG_WRITE_COD_GENRE = "Write a cod GENRE ";
	public static final String MSG_WRITE_NEWNAME = "Write a name ";
	public static final String MSG_WRITE_NEWCOD_GENRE = "Write a cod GENRE ";
}
