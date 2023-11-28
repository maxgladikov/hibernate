package online.gladikov.hibernate;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import online.gladikov.hibernate.model.caveat_emptor.Address;
import online.gladikov.hibernate.model.caveat_emptor.User;

@Slf4j
public class CaveatEmptor {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("caveat_emptor");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		User someUser = new User();
		someUser.setName("johndoe");
		Address someAddress = new Address("Some Street 123", "12345", "Some City");
		someUser.setShippingAddress(someAddress);
		em.persist(someUser);
		
		tx.commit();
		
		// ************************* \\
//		tx = em.getTransaction();
		tx.begin();
		//
		var anotherUser=em.find(User.class, 1L);
		log.info("user: {}",anotherUser.toString());
		log.info("address: {}",anotherUser.getShippingAddress().toString());
		tx.commit();
		em.close();
	}
}

