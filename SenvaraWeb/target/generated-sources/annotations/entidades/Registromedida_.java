package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Registromedida.class)
public abstract class Registromedida_ {

	public static volatile SingularAttribute<Registromedida, Integer> idRegistroMedida;
	public static volatile SingularAttribute<Registromedida, Date> fechaHora;
	public static volatile SingularAttribute<Registromedida, Double> valor;
	public static volatile SingularAttribute<Registromedida, Sensor> sensor;

}

