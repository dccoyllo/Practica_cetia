package udaff.edu.pe.entities;
// Generated 29-oct-2020 13:26:46 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UsuReser generated by hbm2java
 */
@Entity
@Table(name = "usu_reser", catalog = "bd_cetia_v2")
public class UsuReser implements java.io.Serializable {

	private int idusuReser;
	private Reservacion reservacion;
	private Usuario usuario;

	public UsuReser() {
	}

	public UsuReser(int idusuReser, Reservacion reservacion, Usuario usuario) {
		this.idusuReser = idusuReser;
		this.reservacion = reservacion;
		this.usuario = usuario;
	}

	@Id

	@Column(name = "idusu_reser", unique = true, nullable = false)
	public int getIdusuReser() {
		return this.idusuReser;
	}

	public void setIdusuReser(int idusuReser) {
		this.idusuReser = idusuReser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idreservacion", nullable = false)
	public Reservacion getReservacion() {
		return this.reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
