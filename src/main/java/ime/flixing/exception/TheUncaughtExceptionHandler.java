package ime.flixing.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class TheUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
    public void uncaughtException(Thread t, Throwable e) {
		
        if (e instanceof NullPointerException) {
            handleNullPointerException((NullPointerException) e);
            
        } else if (e instanceof java.lang.IllegalStateException) {
            handleIllegalStateException((java.lang.IllegalStateException) e);
            
        } else if (e instanceof org.hibernate.service.spi.ServiceException) {
            handleIllegalServiceException((org.hibernate.service.spi.ServiceException) e);
            
        }else if (e instanceof org.hibernate.engine.jdbc.env.spi.JdbcEnvironment) {
            handleJdbcEnvironmentException((org.hibernate.engine.jdbc.env.spi.JdbcEnvironment) e);
        }
        else {
            handleGenericException(e);
        }
    }

    private void handleNullPointerException(NullPointerException e) {
        System.out.println("Se ha producido una excepción de puntero nulo: " + e.getMessage());
    }

    private void handleIllegalStateException(java.lang.IllegalStateException e) {
        System.out.println("Se ha producido una excepción de java.lang.IllegalStateException: " + e.getMessage());
    }

    private void handleIllegalServiceException(org.hibernate.service.spi.ServiceException e) {
        System.out.println("Se ha producido una excepción de org.hibernate.service.spi.ServiceException: " + e.getMessage());
    }

    private void handleJdbcEnvironmentException(org.hibernate.engine.jdbc.env.spi.JdbcEnvironment e) {
        System.out.println("Se ha producido una excepción de org.hibernate.engine.jdbc.env.spi.JdbcEnvironment: ");
    }

    private void handleGenericException(Throwable e) {
        System.out.println("Se ha producido una excepción desconocida: " + e.getMessage());
    }

}
