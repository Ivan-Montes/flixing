package ime.flixing.exception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import ime.flixing.tool.DecoHelper;

public class TheUncaughtExceptionHandler implements UncaughtExceptionHandler {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Override
    public void uncaughtException(Thread t, Throwable e) {
		
		String msg = "";
		
        if (e instanceof NullPointerException ex) {
        	msg = String.format(DecoHelper.EX_MSG_TEMPLATE, DecoHelper.EX_NULL, ex.getMessage());
            
        } else if (e instanceof java.lang.IllegalStateException ex) {
        	msg = String.format(DecoHelper.EX_MSG_TEMPLATE, DecoHelper.EX_ILLEGAL_STATE, ex.getMessage());
            
        } else if (e instanceof org.hibernate.service.spi.ServiceException ex) {
        	msg = String.format(DecoHelper.EX_MSG_TEMPLATE, DecoHelper.EX_ILLEGAL_SERVICE, ex.getMessage());
            
        }else if (e instanceof org.hibernate.engine.jdbc.env.spi.JdbcEnvironment ex) {
        	msg = String.format(DecoHelper.EX_MSG_TEMPLATE, DecoHelper.EX_HIBERNATE_JDBC, ((Throwable) ex).getMessage());
        }
        else {
        	msg = String.format(DecoHelper.EX_MSG_TEMPLATE, DecoHelper.EX_UNKNOWN, e.getMessage());
        }
        
        logger.log(Level.SEVERE, msg );
    }

}
