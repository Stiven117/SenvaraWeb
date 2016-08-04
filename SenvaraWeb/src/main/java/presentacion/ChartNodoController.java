package presentacion;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import negocio.GestionBean;

@ManagedBean
public class ChartNodoController {
	@ManagedProperty(value="#{chartNodoModel}")
	private ChartNodoModel chart;
	
	@EJB
	GestionBean gestionBean;
	
	@PostConstruct
	public void init()
	{
		chart.setRegistros(gestionBean.obtenerGraficaDeNodo(1));
		chart.updateAnimatedModels();
	}

	public ChartNodoModel getChart() {
		return chart;
	}

	public void setChart(ChartNodoModel chart) {
		this.chart = chart;
	}
	
	public String buscar(){
		String filtro = chart.getFiltroTiempo(); //Obtener el valor seleccionado del modelo
		//Realizar lo que haya que hacer
		return "index"; //Revisar si funciona es con index.xhtml
	}
	
}
