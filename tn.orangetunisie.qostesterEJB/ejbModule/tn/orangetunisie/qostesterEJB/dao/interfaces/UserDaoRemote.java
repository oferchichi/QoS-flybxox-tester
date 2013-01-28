package tn.orangetunisie.qostesterEJB.dao.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.orangetunisie.qostesterEJB.entities.User;

@Remote
public interface UserDaoRemote {

	public void addUser(User user) ;
	public void updUser(User user) ;
	public  User findUser(String idUser) ;
	public void delUser(User user);
	public List<User> getAllUser();
}
