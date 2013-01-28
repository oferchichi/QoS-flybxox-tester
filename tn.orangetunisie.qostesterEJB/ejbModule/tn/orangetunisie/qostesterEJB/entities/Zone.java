package tn.orangetunisie.qostesterEJB.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Zone
 *
 */
@Entity
@Table(name="tbl_zone")

public class Zone implements Serializable {

	
	private int idZone;
	private String nomZone;
	private List<FtpTest> ftpTests ;
	private List<HttpTest> httpTests ;
	private List<StreamTest> streamTests;
	private static final long serialVersionUID = 1L;

	public Zone() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdZone() {
		return this.idZone;
	}

	public void setIdZone(int idZone) {
		this.idZone = idZone;
	}   
	public String getNomZone() {
		return this.nomZone;
	}

	public void setNomZone(String nomZone) {
		this.nomZone = nomZone;
	}
	
	@OneToMany(mappedBy="zone",cascade=CascadeType.ALL)
	public List<FtpTest> getFtpTests() {
		return ftpTests;
	}
	
	
	public void setFtpTests(List<FtpTest> ftpTests) {
		this.ftpTests = ftpTests;
	}
	
	@OneToMany(mappedBy="zone",cascade=CascadeType.ALL)

	public List<HttpTest> getHttpTests() {
		return httpTests;
	}
	public void setHttpTests(List<HttpTest> httpTests) {
		this.httpTests = httpTests;
	}
	
	@OneToMany(mappedBy="zone",cascade=CascadeType.ALL)

	public List<StreamTest> getStreamTests() {
		return streamTests;
	}
	public void setStreamTests(List<StreamTest> streamTests) {
		this.streamTests = streamTests;
	}
   
}
