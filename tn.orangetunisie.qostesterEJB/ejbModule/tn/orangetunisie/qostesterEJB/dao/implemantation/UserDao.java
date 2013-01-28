package tn.orangetunisie.qostesterEJB.dao.implemantation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.orangetunisie.qostesterEJB.dao.interfaces.UserDaoLocal;
import tn.orangetunisie.qostesterEJB.dao.interfaces.UserDaoRemote;
import tn.orangetunisie.qostesterEJB.entities.User;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
public class UserDao implements UserDaoRemote, UserDaoLocal {
	
	@PersistenceContext(unitName="tn.orangetunisie.qostesterEJB")
	EntityManager entityManager ;

    public UserDao() {
       
    }

	@Override
	public void addUser(User user) {
      entityManager.persist(user);
		
	}

	@Override
	public void updUser(User user) {

		entityManager.merge(user);
	}

	@Override
	public User findUser(String idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public void delUser(User user) {
       entityManager.remove(findUser(user.getLoginUser()));		
	}

	@Override
	public List<User> getAllUser() {
		return entityManager.createQuery("from User u").getResultList();
	}

}
