package Ammon1.SpringMVC.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Ammon1.SpringMVC.Entity.Skirts;

@Repository
public class SkirtsDAOImpl implements SkirtsDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Transactional
	public List<Skirts> getSkirts() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Skirts> theQuery = 
				currentSession.createQuery("from Customer", Skirts.class);
		
		// execute query and get result list
		List<Skirts> skirts = theQuery.getResultList();
				
		// return the results		
		return skirts;
	}

}






