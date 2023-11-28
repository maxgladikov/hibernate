package online.gladikov.hibernate.boot;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import online.gladikov.hibernate.model.dns.Product;
/**
 * // ******* Hibernate Native Bootstrapping **********
 */
@Slf4j
public class SessionFactoryProvider {
	private static SessionFactory factory;
	private SessionFactoryProvider(){}
	
	public static SessionFactory get() {
		if(factory==null)
			factory=bootstrap();
		return factory;
	}
	
	private static SessionFactory bootstrap() {
		MetadataSources metadataSources;
		Metadata metadata;
		StandardServiceRegistry registry;
		SessionFactoryBuilder sessionFactoryBuilder;
		SessionFactory sessionFactory;
		
		log.trace("***** Starting configuration *****");
		registry = new StandardServiceRegistryBuilder()
				.loadProperties("hibernate.properties")
				.build();

		metadataSources = new MetadataSources(registry)
				.addAnnotatedClass(Product.class);
			// the parsed representations of an application domain model and its mapping to a database.
		metadata =	metadataSources.buildMetadata();

		sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build();
		log.trace("***** Configuration completed sucessfully *****");
		return sessionFactory;
	}
	
}
