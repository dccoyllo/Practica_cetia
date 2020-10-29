package udaff.edu.pe.entities;
// Generated 29-oct-2020 13:26:46 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Psicologo generated by hbm2java
 */
@Entity
@Table(name = "psicologo", catalog = "bd_cetia_v2")
public class Psicologo implements java.io.Serializable {

	private int idusuario;
	private Usuario usuario;
	private String especialidad;
	private String imagen;
	private Set<PsicPubl> psicPubls = new HashSet<PsicPubl>(0);
	private Set<PsicAct> psicActs = new HashSet<PsicAct>(0);
	private Set<PsicServ> psicServs = new HashSet<PsicServ>(0);

	public Psicologo() {
	}

	public Psicologo(Usuario usuario, String especialidad) {
		this.usuario = usuario;
		this.especialidad = especialidad;
	}

	public Psicologo(Usuario usuario, String especialidad, String imagen, Set<PsicPubl> psicPubls,
			Set<PsicAct> psicActs, Set<PsicServ> psicServs) {
		this.usuario = usuario;
		this.especialidad = especialidad;
		this.imagen = imagen;
		this.psicPubls = psicPubls;
		this.psicActs = psicActs;
		this.psicServs = psicServs;
	}

	@GenericGenerator(name = "udaff.edu.pe.entities.PsicologoIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "usuario"))
	@Id
	@GeneratedValue(generator = "udaff.edu.pe.entities.PsicologoIdGenerator")

	@Column(name = "idusuario", unique = true, nullable = false)
	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "especialidad", nullable = false, length = 50)
	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Column(name = "imagen", length = 100)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "psicologo")
	public Set<PsicPubl> getPsicPubls() {
		return this.psicPubls;
	}

	public void setPsicPubls(Set<PsicPubl> psicPubls) {
		this.psicPubls = psicPubls;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "psicologo")
	public Set<PsicAct> getPsicActs() {
		return this.psicActs;
	}

	public void setPsicActs(Set<PsicAct> psicActs) {
		this.psicActs = psicActs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "psicologo")
	public Set<PsicServ> getPsicServs() {
		return this.psicServs;
	}

	public void setPsicServs(Set<PsicServ> psicServs) {
		this.psicServs = psicServs;
	}

}