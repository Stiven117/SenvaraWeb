package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the senvara database table.
 * 
 */
@Entity
@NamedQuery(name="Senvara.findAll", query="SELECT s FROM Senvara s")
public class Senvara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSenvara;

	private float version;

	//bi-directional many-to-one association to Nodo
	@OneToMany(mappedBy="senvara")
	private List<Nodo> nodos;

	public Senvara() {
	}

	public int getIdSenvara() {
		return this.idSenvara;
	}

	public void setIdSenvara(int idSenvara) {
		this.idSenvara = idSenvara;
	}

	public float getVersion() {
		return this.version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public List<Nodo> getNodos() {
		return this.nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public Nodo addNodo(Nodo nodo) {
		getNodos().add(nodo);
		nodo.setSenvara(this);

		return nodo;
	}

	public Nodo removeNodo(Nodo nodo) {
		getNodos().remove(nodo);
		nodo.setSenvara(null);

		return nodo;
	}

}