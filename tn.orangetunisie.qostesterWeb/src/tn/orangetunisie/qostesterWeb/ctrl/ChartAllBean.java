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
public class ChartAllBean {

	public CartesianChartModel linearModel;

	@EJB
	FtpTestDaoLocal ftpTestDaoLocal;

	public ChartAllBean() {
	}

	@PostConstruct
	public void init() {
		createLinearModel();
	}

	private void createLinearModel() {
		linearModel = new CartesianChartModel();

		List<FtpTest> ftpTimeTest = ftpTestDaoLocal.getBytime();
		LineChartSeries seriesFlybox = new LineChartSeries();
		LineChartSeries seriesKeypro = new LineChartSeries();
		LineChartSeries serieskeygp = new LineChartSeries();
		LineChartSeries seriesweborange = new LineChartSeries();
		LineChartSeries seriesblackbery = new LineChartSeries();
		LineChartSeries seriesiphone = new LineChartSeries();
		seriesFlybox.setLabel("Flybox");
		seriesKeypro.setLabel("Keypro");
		serieskeygp.setLabel("keygp");
		seriesweborange.setLabel("weborange");
		seriesiphone.setLabel("iphone");
		seriesblackbery.setLabel("blackberry");
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("flybox")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesFlybox.set(timeformat, f.getValeur());
				System.out.println("flybox : " + f.getValeur() + " - "
						+ timeformat);
			}

		}
/*
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("keypro")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesKeypro.set(timeformat, f.getValeur());
				System.out.println("keypro : " + f.getValeur());
			}

		}

*/
		/*
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("keygp")) {

				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				serieskeygp.set(timeformat, f.getValeur());
				System.out.println("keypro : " + f.getValeur());
			}
		}
*/
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("weborange")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesweborange.set(timeformat, f.getValeur());
				System.out.println("weborange : " + f.getValeur() + " - "
						+ timeformat);
			}

		}
/*
		for (FtpTest f : ftpTimeTest) {
			if (f.getApn().equals("blackbery")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesblackbery.set(timeformat, f.getValeur());
				System.out.println("blackbery : " + f.getValeur());
			}

		}*/
		
		/*
		for (FtpTest f : ftpTimeTest) {

			if (f.getApn().equals("iphone")) {
				String timeformat = new SimpleDateFormat("HH:mm").format(f
						.getTemps());
				seriesiphone.set(timeformat, f.getValeur());
				System.out.println("iphone : " + f.getValeur());
			}

		}
*/
		linearModel.addSeries(seriesFlybox);
		//linearModel.addSeries(seriesKeypro);
		/*
		  linearModel.addSeries(serieskeygp);
		  linearModel.addSeries(seriesiphone);
		  */
		  linearModel.addSeries(seriesweborange);
		// linearModel.addSeries(seriesblackbery);
		 

	}

	public CartesianChartModel getLinearModel() {
		List<FtpTest> ftpTests = ftpTestDaoLocal.getBytime();

		/*
		 * System.out.println("the sise " +linearModel.getSeries().size()); for
		 * (int i = 0; i<linearModel.getSeries().size(); i++){
		 * System.out.println( linearModel.getSeries().get(i).getLabel()); }
		 */
		/*
		 * for (FtpTest f: ftpTests){ if (f.getApn().equals("flybox")) { String
		 * timeformat = new SimpleDateFormat("H:mm").format(f.getTemps());
		 * linearModel.getSeries().get(0).getData().put(timeformat,
		 * f.getValeur()); }
		 * 
		 * /*if (f.getApn().equals("keypro")){ String timeformat = new
		 * SimpleDateFormat("HH:mm").format(f.getTemps());
		 * linearModel.getSeries().get(1).getData().put(timeformat,
		 * f.getValeur()); } if(f.getApn().equals("keygp")){ String timeformat =
		 * new SimpleDateFormat("HH:mm").format(f.getTemps());
		 * linearModel.getSeries().get().getData().put(timeformat,
		 * f.getValeur()); }
		 * 
		 * if(f.getApn().equals("weborange")){ String timeformat = new
		 * SimpleDateFormat("HH:mm").format(f.getTemps());
		 * linearModel.getSeries().get(1).getData().put(timeformat,
		 * f.getValeur()); }
		 * 
		 * if(f.getApn().equals("iphone")){ String timeformat = new
		 * SimpleDateFormat("HH:mm").format(f.getTemps());
		 * linearModel.getSeries().get(0).getData().put(timeformat,
		 * f.getValeur()); }
		 * 
		 * if(f.getApn().equals("blackbery")){ String timeformat = new
		 * SimpleDateFormat("HH:mm").format(f.getTemps());
		 * linearModel.getSeries().get(0).getData().put(timeformat,
		 * f.getValeur()); }
		 */

		// }

		return linearModel;
	}

}
