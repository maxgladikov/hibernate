package online.gladikov.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import online.gladikov.hibernate.boot.SessionFactoryProvider;
import online.gladikov.hibernate.model.dns.Printer;
import online.gladikov.hibernate.model.dns.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import online.gladikov.hibernate.boot.EntityManagerFactoryProvider;
@Slf4j
public class DNSApp {
	
    public static void main(String[] args) {
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dns");
    	
    	EntityManager em=null;
    	EntityTransaction transaction=null;
    	try {
	    	em=emf.createEntityManager();
	    	transaction=em.getTransaction();
    	} catch(Exception e) {
    		log.error(e.getMessage());
    	}
    	
    	try {
            transaction.begin();
            em.persist(new Product('A',1,"printer"));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) 
                		transaction.rollback();
            log.error(e.getMessage());
        }
        finally {
            em.close();
        }
        
    	
    	/*
    	SessionFactory factory=SessionFactoryProvider.get();
    	Session session=factory.openSession();
    	Transaction transaction=session.beginTransaction();
    	session.persist(new Product('B',2,"laptop"));;
    	transaction.commit();
    	factory.close();
    	*/
    }
}
