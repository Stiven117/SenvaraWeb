package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registromedida database table.
 * 
 */
@Entity
@NamedQuery(name="Registromedida.findAll", query="SELECT r FROM Registromedida r")
public class Registromedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroMedida;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;

	private double valor;

	//bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name="idSensor")
	private Sensor sensor;

	public Registromedida() {
	}

	public int getIdRegistroMedida() {
		return this.idRegistroMedida;
	}

	public void setIdRegistroMedida(int idRegistroMedida) {
		this.idRegistroMedida = idRegistroMedida;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}