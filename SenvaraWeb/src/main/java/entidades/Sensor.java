package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sensor database table.
 * 
 */
@Entity
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSensor;

	private String descripcion;

	private String nombre;

	private String unidadMedida;

	//bi-directional many-to-one association to Registromedida
	@OneToMany(mappedBy="sensor")
	private List<Registromedida> registromedidas;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="idNodo")
	private Nodo nodo;

	public Sensor() {
	}

	public int getIdSensor() {
		return this.idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
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

	public String getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public List<Registromedida> getRegistromedidas() {
		return this.registromedidas;
	}

	public void setRegistromedidas(List<Registromedida> registromedidas) {
		this.registromedidas = registromedidas;
	}

	public Registromedida addRegistromedida(Registromedida registromedida) {
		getRegistromedidas().add(registromedida);
		registromedida.setSensor(this);

		return registromedida;
	}

	public Registromedida removeRegistromedida(Registromedida registromedida) {
		getRegistromedidas().remove(registromedida);
		registromedida.setSensor(null);

		return registromedida;
	}

	public Nodo getNodo() {
		return this.nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

}