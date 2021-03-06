package tn.orangetunisie.qostesterWeb.ctrl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

import tn.orangetunisie.qostesterEJB.dao.interfaces.FtpTestDaoLocal;
import tn.orangetunisie.qostesterEJB.entities.FtpTest;


@ManagedBean
@SessionScoped
public class KeyproChartBean {


	public CartesianChartModel linearModel;

	@EJB
	FtpTestDaoLocal ftpTestDaoLocal;

	public KeyproChartBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		createLinearModel();
	}

	private void createLinearModel() {
		linearModel = new CartesianChartModel();

		List<FtpTest> ftpTimeTest = ftpTestDaoLocal.getAllTest();
		LineChartSeries seriesKeypro = new LineChartSeries();
		seriesKeypro.setLabel("Keypro");
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("keypro")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesKeypro.set(timeformat, f.getValeur());
				System.out.println("flybox : " + f.getValeur() + " - "
						+ timeformat);
			}

		}

		linearModel.addSeries(seriesKeypro);
	}

	public CartesianChartModel getLinearModel() {
		List<FtpTest> ftpTests = ftpTestDaoLocal.getBytime();

		for (FtpTest f : ftpTests) {
			if (f.getApn().equals("keypro")) {
				String timeformat = new SimpleDateFormat("H:mm").format(f
						.getTemps());
				linearModel.getSeries().get(0).getData()
						.put(timeformat, f.getValeur());
			}

		}

		return linearModel;
	}

	
}
