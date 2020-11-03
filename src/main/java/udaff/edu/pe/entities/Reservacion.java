package udaff.edu.pe.entities;
// Generated 02-nov-2020 22:55:50 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reservacion generated by hbm2java
 */
@Entity
@Table(name = "reservacion", catalog = "bd_cetia_v2")
public class Reservacion implements java.io.Serializable {

	private Integer idreservacion;
	private Usuario usuario;
	private Date fecha;
	private Date hora;
	private double precio;
	private Boolean atencion;
	private int idservicio;

	public Reservacion() {
	}

	public Reservacion(Usuario usuario, Date fecha, Date hora, double precio, int idservicio) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.idservicio = idservicio;
	}

	public Reservacion(Usuario usuario, Date fecha, Date hora, double precio, Boolean atencion, int idservicio) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.atencion = atencion;
		this.idservicio = idservicio;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idreservacion", unique = true, nullable = false)
	public Integer getIdreservacion() {
		return this.idreservacion;
	}

	public void setIdreservacion(Integer idreservacion) {
		this.idreservacion = idreservacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora", nullable = false, length = 8)
	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Column(name = "precio", nullable = false, precision = 22, scale = 0)
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name = "atencion")
	public Boolean getAtencion() {
		return this.atencion;
	}

	public void setAtencion(Boolean atencion) {
		this.atencion = atencion;
	}

	@Column(name = "idservicio", nullable = false)
	public int getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}

}
