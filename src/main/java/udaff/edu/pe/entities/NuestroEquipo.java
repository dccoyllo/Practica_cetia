package udaff.edu.pe.entities;
// Generated 02-nov-2020 20:08:02 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * NuestroEquipo generated by hbm2java
 */
@Entity
@Table(name = "nuestro_equipo", catalog = "bd_cetia_v2")
public class NuestroEquipo implements java.io.Serializable {

	private NuestroEquipoId id;

	public NuestroEquipo() {
	}

	public NuestroEquipo(NuestroEquipoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "nombre", column = @Column(name = "nombre", length = 50)),
			@AttributeOverride(name = "apellido", column = @Column(name = "apellido", length = 50)),
			@AttributeOverride(name = "especialidad", column = @Column(name = "especialidad", nullable = false, length = 50)),
			@AttributeOverride(name = "foto", column = @Column(name = "foto", length = 100)) })
	public NuestroEquipoId getId() {
		return this.id;
	}

	public void setId(NuestroEquipoId id) {
		this.id = id;
	}

}