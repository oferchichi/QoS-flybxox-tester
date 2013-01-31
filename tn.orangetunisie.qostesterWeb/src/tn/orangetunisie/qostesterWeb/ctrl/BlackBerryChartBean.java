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
public class BlackBerryChartBean {


	public CartesianChartModel linearModel;

	@EJB
	FtpTestDaoLocal ftpTestDaoLocal;

	public BlackBerryChartBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		createLinearModel();
	}

	private void createLinearModel() {
		linearModel = new CartesianChartModel();

		List<FtpTest> ftpTimeTest = ftpTestDaoLocal.getAllTest();
		LineChartSeries seriesblack = new LineChartSeries();
		seriesblack.setLabel("BlackBerry");
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("blackBerry")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesblack.set(timeformat, f.getValeur());
				}

		}

		linearModel.addSeries(seriesblack);
	}

	public CartesianChartModel getLinearModel() {
		List<FtpTest> ftpTests = ftpTestDaoLocal.getBytime();

		for (FtpTest f : ftpTests) {
			if (f.getApn().equals("blackberry")) {
				String timeformat = new SimpleDateFormat("H:mm").format(f
						.getTemps());
				linearModel.getSeries().get(0).getData()
						.put(timeformat, f.getValeur());
			}

		}

		return linearModel;
	}


	
}
