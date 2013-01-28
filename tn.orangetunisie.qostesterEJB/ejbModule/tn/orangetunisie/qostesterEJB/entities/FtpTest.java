package tn.orangetunisie.qostesterEJB.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FtpTest
 *
 */
@Entity

public class FtpTest implements Serializable {

	
	private int idTest;
	private String apn;
	private Date jour;
	private Date temps ;
	private double valeur;
	private Zone zone ;
	private static final long serialVersionUID = 1L;

	public FtpTest() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdTest() {
		return this.idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}   
	public String getApn() {
		return this.apn;
	}

	public void setApn(String apn) {
		this.apn = apn;
	}   
	
	public double getValeur() {
		return this.valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	@ManyToOne
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getJour() {
		return jour;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getTemps() {
		return temps;
	}
	public void setTemps(Date temps) {
		this.temps = temps;
	}
   
}
