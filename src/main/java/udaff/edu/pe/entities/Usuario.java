package udaff.edu.pe.entities;
// Generated 29-oct-2020 13:26:46 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "bd_cetia_v2", uniqueConstraints = { @UniqueConstraint(columnNames = "correo"),
		@UniqueConstraint(columnNames = "cuenta"), @UniqueConstraint(columnNames = "dni") })
public class Usuario implements java.io.Serializable {

	private Integer idusuario;
	private Rol rol;
	private String cuenta;
	private String clave;
	private String correo;
	private String nombre;
	private String apellido;
	private Integer edad;
	private Integer dni;
	private Psicologo psicologo;
	private Set<UsuReser> usuResers = new HashSet<UsuReser>(0);

	public Usuario() {
	}

	public Usuario(Rol rol, String cuenta, String clave) {
		this.rol = rol;
		this.cuenta = cuenta;
		this.clave = clave;
	}

	public Usuario(Rol rol, String cuenta, String clave, String correo, String nombre, String apellido, Integer edad,
			Integer dni, Psicologo psicologo, Set<UsuReser> usuResers) {
		this.rol = rol;
		this.cuenta = cuenta;
		this.clave = clave;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.psicologo = psicologo;
		this.usuResers = usuResers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrol", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "cuenta", unique = true, nullable = false, length = 50)
	public String getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@Column(name = "clave", nullable = false, length = 50)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "correo", unique = true, length = 50)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", length = 50)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "edad")
	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Column(name = "dni", unique = true)
	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Psicologo getPsicologo() {
		return this.psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<UsuReser> getUsuResers() {
		return this.usuResers;
	}

	public void setUsuResers(Set<UsuReser> usuResers) {
		this.usuResers = usuResers;
	}

}
