package spring.webservices.service.dao;




import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.webservices.service.model.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void persistUser(User user) {
		
		try{
			sessionFactory.getCurrentSession().persist(user);
		}catch (ConstraintViolationException e) {           
			throw e;
	    }
		
	}

	@Override
	public User findUserById(String id) {
		System.out.println("NIF ENTROU " + id);
	
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);

	}
	
	@Override
	public void deleteUser(String id) {
		User usr= (User)sessionFactory.getCurrentSession().get(User.class, id);
		sessionFactory.getCurrentSession().delete(usr);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public List getDetailsUsers(String name) {
		System.out.println("entrou name" + name);
		List criteria =sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("name", name + "%")).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return criteria;
		
		
	}

	@Override
	public List getUsers() {
		
		List criteria =sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
		
		return criteria;
	}

}
	

