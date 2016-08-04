package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nodo database table.
 * 
 */
@Entity
@NamedQuery(name="Nodo.findAll", query="SELECT n FROM Nodo n")
public class Nodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idNodo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Senvara
	@ManyToOne
	@JoinColumn(name="idSenvara")
	private Senvara senvara;

	//bi-directional many-to-one association to Sensor
	@OneToMany(mappedBy="nodo")
	private List<Sensor> sensors;

	public Nodo() {
	}

	public int getIdNodo() {
		return this.idNodo;
	}

	public void setIdNodo(int idNodo) {
		this.idNodo = idNodo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Senvara getSenvara() {
		return this.senvara;
	}

	public void setSenvara(Senvara senvara) {
		this.senvara = senvara;
	}

	public List<Sensor> getSensors() {
		return this.sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public Sensor addSensor(Sensor sensor) {
		getSensors().add(sensor);
		sensor.setNodo(this);

		return sensor;
	}

	public Sensor removeSensor(Sensor sensor) {
		getSensors().remove(sensor);
		sensor.setNodo(null);

		return sensor;
	}

}