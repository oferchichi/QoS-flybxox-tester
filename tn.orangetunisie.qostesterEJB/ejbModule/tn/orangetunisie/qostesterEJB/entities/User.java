package tn.orangetunisie.qostesterEJB.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="tbl_users")

public class User implements Serializable {

	
	private int idUsers;
	private String LoginUser;
	private String passUser;
	private String emailUser;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}   
	@Id    
	public String getLoginUser() {
		return this.LoginUser;
	}

	public void setLoginUser(String LoginUser) {
		this.LoginUser = LoginUser;
	}   
	public String getPassUser() {
		return this.passUser;
	}

	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}   
	public String getEmailUser() {
		return this.emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
   
}
