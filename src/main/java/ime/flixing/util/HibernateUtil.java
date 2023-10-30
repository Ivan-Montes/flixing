package ime.flixing.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ime.flixing.entity.*;

public class HibernateUtil {

private static final SessionFactory sessionFactory;


	static {
		
			final ServiceRegistry registry = new StandardServiceRegistryBuilder()
																	.applySetting("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
																	.applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/flixingdb?useSSL=false")
																	.applySetting("hibernate.connection.username", System.getenv("mysql.flixingdb.user"))
													                .applySetting("hibernate.connection.password", System.getenv("mysql.flixingdb.password"))
													                .applySetting("hibernate.show_sql", "true")
													                .applySetting("hibernate.hbm2ddl.auto", "create")
													                .applySetting("hibernate.hbm2ddl.import_files", "data.sql")
																	.configure()
														            .build();
			try {
				
		        Metadata metadata = new MetadataSources(registry)
		            .addAnnotatedClass(Flix.class)
		            .addAnnotatedClass(Position.class)
		            .addAnnotatedClass(Person.class)
		            .addAnnotatedClass(Genre.class)
		            .addAnnotatedClass(FlixPersonPosition.class)
		            .addAnnotatedClass(FlixPersonPositionId.class)
		            .buildMetadata();		        
		        sessionFactory = metadata.buildSessionFactory();
		        
			} catch (Throwable ex) {
				
			StandardServiceRegistryBuilder.destroy( registry );
			System.err.println(" ##==== Inicio de SessionFactory erroneo ====##\n" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSession() {
		return sessionFactory;
	}
	
	public static void shutdown() {
	        getSession().close();
	}
}
