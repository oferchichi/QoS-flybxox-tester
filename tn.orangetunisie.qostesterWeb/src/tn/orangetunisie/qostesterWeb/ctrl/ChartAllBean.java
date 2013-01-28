package tn.orangetunisie.qostesterWeb.ctrl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

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
       createLinearModel();
    
    }
    private void createLinearModel() {
    	linearModel = new CartesianChartModel();
    
			
			List<FtpTest> ftpTests = ftpTestDaoLocal.getAllTest(); 
            LineChartSeries series1 = new LineChartSeries();  
            series1.setLabel("Flybox");  
            for (FtpTest f: ftpTests){
            	if (f.getApn().equals("flybox")) {
            		  series1.set(f.getTemps(), f.getValeur());
            	}
            }
            linearModel.addSeries(series1);

    
    
            LineChartSeries series2 = new LineChartSeries();  
            series2.setLabel("Series 2");  
            series2.setMarkerStyle("diamond");  
      
            series2.set(1, 6);  
            series2.set(2, 3);  
            series2.set(3, 2);  
            series2.set(4, 7);  
            series2.set(5, 9);  
      
            LineChartSeries series3 = new LineChartSeries();  
            series3.setLabel("Series 3");
            series3.setMarkerStyle("round");
            
            series3.set(0.6, 2);  
            series3.set(2.5, 1);  
            series3.set(3, 4);  
            series3.set(5, 6.6);  
            series3.set(5, 7.2);  

            
            linearModel.addSeries(series2);
            linearModel.addSeries(series3);

    }

    
    public CartesianChartModel getLinearModel() {
		return linearModel;
	}
    
    public void setLinearModel(CartesianChartModel linearModel) {
		this.linearModel = linearModel;
	}

}
