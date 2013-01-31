package tn.orangetunisie.qostesterEJB.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.orangetunisie.qostesterEJB.entities.FtpTest;


@Local
public interface FtpTestDaoLocal {

	
	public List<FtpTest> getAllTest();
	
	public List<FtpTest> getByday() ;
	
	public List<FtpTest> getBytime();
	
	
	
	
}
