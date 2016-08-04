package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sensor.class)
public abstract class Sensor_ {

	public static volatile SingularAttribute<Sensor, String> descripcion;
	public static volatile SingularAttribute<Sensor, String> unidadMedida;
	public static volatile SingularAttribute<Sensor, Integer> idSensor;
	public static volatile ListAttribute<Sensor, Registromedida> registromedidas;
	public static volatile SingularAttribute<Sensor, String> nombre;
	public static volatile SingularAttribute<Sensor, Nodo> nodo;

}

