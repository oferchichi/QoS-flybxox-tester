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
public class WeborangeChartBean {

	

	public CartesianChartModel linearModel;

	@EJB
	FtpTestDaoLocal ftpTestDaoLocal;

	public WeborangeChartBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		createLinearModel();
	}

	private void createLinearModel() {
		linearModel = new CartesianChartModel();

		List<FtpTest> ftpTimeTest = ftpTestDaoLocal.getAllTest();
		LineChartSeries seriesweborange = new LineChartSeries();
		seriesweborange.setLabel("Weborange");
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("weborange")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesweborange.set(timeformat, f.getValeur());
				
			}

		}

		linearModel.addSeries(seriesweborange);
	}

	public CartesianChartModel getLinearModel() {
		List<FtpTest> ftpTests = ftpTestDaoLocal.getBytime();

		for (FtpTest f : ftpTests) {
			if (f.getApn().equals("weborange")) {
				String timeformat = new SimpleDateFormat("H:mm").format(f
						.getTemps());
				linearModel.getSeries().get(0).getData()
						.put(timeformat, f.getValeur());
			}

		}

		return linearModel;
	}


}
