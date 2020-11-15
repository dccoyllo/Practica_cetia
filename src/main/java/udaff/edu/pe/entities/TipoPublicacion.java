package udaff.edu.pe.entities;
// Generated 14 nov. 2020 20:21:29 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoPublicacion generated by hbm2java
 */
@Entity
@Table(name = "tipo_publicacion", catalog = "bd_cetia_v2")
public class TipoPublicacion implements java.io.Serializable {

	private Integer idtipopublicacion;
	private String nombre;
	private Set<Publicacion> publicacions = new HashSet<Publicacion>(0);

	public TipoPublicacion() {
	}

	public TipoPublicacion(String nombre) {
		this.nombre = nombre;
	}

	public TipoPublicacion(String nombre, Set<Publicacion> publicacions) {
		this.nombre = nombre;
		this.publicacions = publicacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtipopublicacion", unique = true, nullable = false)
	public Integer getIdtipopublicacion() {
		return this.idtipopublicacion;
	}

	public void setIdtipopublicacion(Integer idtipopublicacion) {
		this.idtipopublicacion = idtipopublicacion;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPublicacion")
	public Set<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(Set<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

}
