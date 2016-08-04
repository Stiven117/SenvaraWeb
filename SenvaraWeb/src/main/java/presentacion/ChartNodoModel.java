package presentacion;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import entidades.Registromedida;
import negocio.GestionBean;
 
@ManagedBean
public class ChartNodoModel implements Serializable {
	
	@EJB
	GestionBean gestionBean;
 
    private LineChartModel animatedModel1; 
    private LineChartModel animatedModel2;
    private ArrayList<Registromedida> registros;
    
    
    private String filtroTiempo;
    public String getFiltroTiempo() {
		return filtroTiempo;
	}
	public void setFiltroTiempo(String filtroTiempo) {
		this.filtroTiempo = filtroTiempo;
	}

	@PostConstruct
    public void init() {
    	registros = gestionBean.obtenerGraficaDeNodo(1);
		this.updateAnimatedModels();
    }
 
    public ArrayList<Registromedida> getRegistros() {
		return registros;
	}

	public void setRegistros(ArrayList<Registromedida> registros) {
		this.registros = registros;
	}

	public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
	public LineChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    public void updateAnimatedModels()
    {
    	 int reg = registros.size();
    	 animatedModel1 = initLinearModel();
         animatedModel1.setTitle("Grados Centigrados (°C)");
         animatedModel1.setAnimate(true);
         animatedModel1.setLegendPosition("se");
         DateAxis axis = new DateAxis("Fecha, Hora");
         axis.setTickAngle(-50);         
         axis.setMin(registros.get(0).getFechaHora().getTime());
         axis.setMax(registros.get(reg -1).getFechaHora().getTime());
         axis.setTickFormat("%b %e, %H:%M");
         Axis yAxis = animatedModel1.getAxis(AxisType.Y);
         yAxis.setLabel("Temperatura °C");
         yAxis.setMin(0);
         yAxis.setMax(50);  
         animatedModel1.getAxes().put(AxisType.X, axis);
         
         animatedModel2 = initLinearModel2();
         animatedModel2.setTitle("Grados Fahrenheit  (°F)");
         animatedModel2.setAnimate(true);
         animatedModel2.setLegendPosition("se");
         animatedModel2.setSeriesColors("020BBC");
         DateAxis axis2 = new DateAxis("Fecha, Hora");
         axis2.setTickAngle(-50);         
         axis2.setMin(registros.get(0).getFechaHora().getTime());
         axis2.setMax(registros.get(reg -1).getFechaHora().getTime());
         axis2.setTickFormat("%b %e, %H:%M");
         Axis yAxis2 = animatedModel2.getAxis(AxisType.Y);
         yAxis2.setLabel("Temperatura °F");
         yAxis2.setMin(20);
         yAxis2.setMax(120);  
         animatedModel2.getAxes().put(AxisType.X, axis2);
    }
    
	private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Temperatura °C");        
        for (int i= 0; i<registros.size();i++)
        {        	
        	if (registros.get(i).getSensor().getNombre().equals("Temperatura_C"))
        	{           		 		
        		series1.set( registros.get(i).getFechaHora().getTime(), registros.get(i).getValor());
        	}
    	}
        model.addSeries(series1);
        
        return model;
    }
	
	private LineChartModel initLinearModel2() {
        LineChartModel model2 = new LineChartModel();
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Temperatura °F");        
        for (int i= 0; i<registros.size();i++)
        {        	
        	if (registros.get(i).getSensor().getNombre().equals("Temperatura_F"))
        	{           		 		
        		series2.set( registros.get(i).getFechaHora().getTime(), registros.get(i).getValor());
        	}
    	}
        model2.addSeries(series2);
        
        return model2;
    }
    
}