package ime.flixing.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ime.flixing.entity.Flix;
import ime.flixing.entity.Person;
import ime.flixing.entity.Position;

public class HibernateUtil {

private static final SessionFactory sessionFactory;
	
	static {
		
			final ServiceRegistry registry = new StandardServiceRegistryBuilder()
																	.configure()
														            .build();
			try {
				
		        Metadata metadata = new MetadataSources(registry)
		            .addAnnotatedClass(Flix.class)
		            .addAnnotatedClass(Position.class)
		            .addAnnotatedClass(Person.class)
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
}
