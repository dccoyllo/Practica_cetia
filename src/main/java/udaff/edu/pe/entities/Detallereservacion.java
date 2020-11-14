package udaff.edu.pe.entities;
// Generated 14 nov. 2020 18:02:31 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Detallereservacion generated by hbm2java
 */
@Entity
@Table(name = "detallereservacion", catalog = "bd_cetia_v2")
public class Detallereservacion implements java.io.Serializable {

	private DetallereservacionId id;

	public Detallereservacion() {
	}

	public Detallereservacion(DetallereservacionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idservicio", column = @Column(name = "idservicio", nullable = false)),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", nullable = false, length = 10)),
			@AttributeOverride(name = "hora", column = @Column(name = "hora", nullable = false, length = 8)),
			@AttributeOverride(name = "precio", column = @Column(name = "precio", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "servicio", column = @Column(name = "servicio", nullable = false, length = 100)),
			@AttributeOverride(name = "nombreusuario", column = @Column(name = "nombreusuario", length = 50)),
			@AttributeOverride(name = "apellidousuario", column = @Column(name = "apellidousuario", length = 50)),
			@AttributeOverride(name = "dniusuario", column = @Column(name = "dniusuario")) })
	public DetallereservacionId getId() {
		return this.id;
	}

	public void setId(DetallereservacionId id) {
		this.id = id;
	}

}
