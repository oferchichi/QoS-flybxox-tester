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

    public  CartesianChartModel linearModel;
    
    @EJB
    FtpTestDaoLocal ftpTestDaoLocal ;
    
    public ChartAllBean() {
	}
    
    @PostConstruct
    public void init(){
      createLinearModel();
}
    
    
    private void createLinearModel() {
    	linearModel = new CartesianChartModel();
    
		
			List<FtpTest> ftpTests = ftpTestDaoLocal.getAllTest(); 
            LineChartSeries series1 = new LineChartSeries();  
            series1.setLabel("Flybox");  
            for (FtpTest f: ftpTests){
            	if (f.getApn().equals("flybox")) {
            		System.out.println(f.getIdTest() + " - " + f.getApn() + " - "  +f.getValeur());
            		String timeformat = new SimpleDateFormat("H:mm").format(f.getTemps());
            		series1.set(timeformat, f.getValeur());
            	}
            }
           

   
            linearModel.addSeries(series1);
        
    }

    
    public CartesianChartModel getLinearModel() {
    	List<FtpTest> ftpTests = ftpTestDaoLocal.getAllTest(); 
      
        for (FtpTest f: ftpTests){
        	if (f.getApn().equals("flybox")) {
        		System.out.println(f.getIdTest() + " - " + f.getApn() + " - "  +f.getValeur());
        		String timeformat = new SimpleDateFormat("H:mm").format(f.getTemps());
        		linearModel.getSeries().get(0).getData().put(timeformat, f.getValeur());
        	}
        }
       
		return linearModel;
	}
    
   

}
