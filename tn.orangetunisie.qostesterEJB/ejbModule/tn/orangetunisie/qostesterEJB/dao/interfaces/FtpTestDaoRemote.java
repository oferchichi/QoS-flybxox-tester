package tn.orangetunisie.qostesterEJB.dao.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.orangetunisie.qostesterEJB.entities.FtpTest;


@Remote
public interface FtpTestDaoRemote {

	public List<FtpTest> getAllTest();
}
