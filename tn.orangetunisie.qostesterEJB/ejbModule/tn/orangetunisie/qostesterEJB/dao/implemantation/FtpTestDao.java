package tn.orangetunisie.qostesterEJB.dao.implemantation;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.orangetunisie.qostesterEJB.dao.interfaces.FtpTestDaoLocal;
import tn.orangetunisie.qostesterEJB.dao.interfaces.FtpTestDaoRemote;
import tn.orangetunisie.qostesterEJB.entities.FtpTest;

/**
 * Session Bean implementation class FtpTestDao
 */
@Stateless
public class FtpTestDao implements FtpTestDaoRemote, FtpTestDaoLocal   {

	
	@PersistenceContext(unitName="tn.orangetunisie.qostesterEJB")
	EntityManager entityManager ;
	
    /**
     * Default constructor. 
     */
    public FtpTestDao() {
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<FtpTest> getAllTest() {
        
		
		return entityManager.createQuery("from FtpTest").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FtpTest> getByday() {
	
		return 	entityManager.createQuery("from FtpTest ftp where ftp.jour=curdate()").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FtpTest> getBytime() {
		
      return 	entityManager.createQuery("from FtpTest ftp where ftp.temps between '00:01:00' and '23:59:00' and ftp.jour=curdate()").getResultList();
	}
	
	

   
}
