package tn.orangetunisie.qostesterEJB.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PingTest
 *
 */
@Entity

public class PingTest implements Serializable {

	
	private int idPing;
	private Date jour;
	private Date temps ;
	private double min;
	private double avg;
	private double max;
	private double perte;
	private static final long serialVersionUID = 1L;

	public PingTest() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPing() {
		return this.idPing;
	}

	public void setIdPing(int idPing) {
		this.idPing = idPing;
	}   
	
	public double getMin() {
		return this.min;
	}

	public void setMin(double min) {
		this.min = min;
	}   
	public double getAvg() {
		return this.avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}   
	public double getMax() {
		return this.max;
	}

	public void setMax(double max) {
		this.max = max;
	}   
	public double getPerte() {
		return this.perte;
	}

	public void setPerte(double perte) {
		this.perte = perte;
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
