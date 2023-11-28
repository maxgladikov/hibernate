package online.gladikov.hibernate.boot;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
/**
 *  Jakarta Persistence Bootstrapping
 */
@Slf4j
public class EntityManagerFactoryProvider {
	private static EntityManagerFactory factory;
	private EntityManagerFactoryProvider(){}
	
	public static EntityManagerFactory get() {
		if(factory==null)
			factory=bootstrap();
		return factory;
	}
	
	private static EntityManagerFactory bootstrap() {
		EntityManagerFactory entityManagerFactory=null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("online.gladikov.hibernate.jpa");
			log.trace("***** JPA complient configuration completed *****");
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		return entityManagerFactory;
	}
}
