package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.w3c.dom.ElementTraversal;

import dto.User;
public class UserDao{

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void addUser(User user){
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}
	
	public List<User> login(String email){
		return manager.createQuery("select u from User u where email=?1").setParameter(1, email).getResultList();
	}
	
	public List<User> view_customer(){
		return manager.createQuery("select u from User u where role='customer'").getResultList();
		
	}	
	public List<User> findById(int id)
	{
		return manager.createQuery("select u from User u where id=?1").setParameter(1, id).getResultList();
	}
		
}
	
