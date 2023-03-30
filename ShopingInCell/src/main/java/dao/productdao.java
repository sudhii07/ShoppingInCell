package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Product;

public class productdao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void add_product(Product product) {

		transaction.begin();
		manager.persist(product);
		transaction.commit();
	}

	public List<Product> fetchproducts() {
		return manager.createQuery("select w from Product w").getResultList();

	}
	public Product fetchproduct(int id) {
		return manager.find(Product.class,id);
		
	}
	public void deleteproduct(Product product) {
		transaction.begin();
		manager.remove(product);
		transaction.commit();
	}
	public void Update(Product product) {
		transaction.begin();
		manager.merge(product);
		transaction.commit();
	}
}
