package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nodo.class)
public abstract class Nodo_ {

	public static volatile SingularAttribute<Nodo, String> descripcion;
	public static volatile ListAttribute<Nodo, Sensor> sensors;
	public static volatile SingularAttribute<Nodo, Integer> idNodo;
	public static volatile SingularAttribute<Nodo, String> nombre;
	public static volatile SingularAttribute<Nodo, Senvara> senvara;

}

