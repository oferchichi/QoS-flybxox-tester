package tn.orangetunisie.qostesterEJB.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.orangetunisie.qostesterEJB.entities.User;

@Local
public interface UserDaoLocal {
	public void addUser(User user) ;
	public void updUser(User user) ;
	public  User findUser(String idUser) ;
	public void delUser(User user);
	public List<User> getAllUser();
}
