package udaff.edu.pe.entities;
// Generated 02-nov-2020 20:08:02 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NuestroservicioId generated by hbm2java
 */
@Embeddable
public class NuestroservicioId implements java.io.Serializable {

	private int codigo;
	private String titulo;
	private String descripcion;
	private String imagen;
	private double precio;
	private String tipo;

	public NuestroservicioId() {
	}

	public NuestroservicioId(int codigo, String titulo, double precio, String tipo) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.precio = precio;
		this.tipo = tipo;
	}

	public NuestroservicioId(int codigo, String titulo, String descripcion, String imagen, double precio, String tipo) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.tipo = tipo;
	}

	@Column(name = "codigo", nullable = false)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Column(name = "titulo", nullable = false, length = 100)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "descripcion", length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "imagen", length = 100)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "precio", nullable = false, precision = 22, scale = 0)
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name = "tipo", nullable = false, length = 50)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NuestroservicioId))
			return false;
		NuestroservicioId castOther = (NuestroservicioId) other;

		return (this.getCodigo() == castOther.getCodigo())
				&& ((this.getTitulo() == castOther.getTitulo()) || (this.getTitulo() != null
						&& castOther.getTitulo() != null && this.getTitulo().equals(castOther.getTitulo())))
				&& ((this.getDescripcion() == castOther.getDescripcion())
						|| (this.getDescripcion() != null && castOther.getDescripcion() != null
								&& this.getDescripcion().equals(castOther.getDescripcion())))
				&& ((this.getImagen() == castOther.getImagen()) || (this.getImagen() != null
						&& castOther.getImagen() != null && this.getImagen().equals(castOther.getImagen())))
				&& (this.getPrecio() == castOther.getPrecio())
				&& ((this.getTipo() == castOther.getTipo()) || (this.getTipo() != null && castOther.getTipo() != null
						&& this.getTipo().equals(castOther.getTipo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigo();
		result = 37 * result + (getTitulo() == null ? 0 : this.getTitulo().hashCode());
		result = 37 * result + (getDescripcion() == null ? 0 : this.getDescripcion().hashCode());
		result = 37 * result + (getImagen() == null ? 0 : this.getImagen().hashCode());
		result = 37 * result + (int) this.getPrecio();
		result = 37 * result + (getTipo() == null ? 0 : this.getTipo().hashCode());
		return result;
	}

}
