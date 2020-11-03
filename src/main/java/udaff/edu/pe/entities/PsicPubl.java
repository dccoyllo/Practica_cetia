package udaff.edu.pe.entities;
// Generated 02-nov-2020 19:08:29 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PsicPubl generated by hbm2java
 */
@Entity
@Table(name = "psic_publ", catalog = "bd_cetia_v2")
public class PsicPubl implements java.io.Serializable {

	private Integer idpsicPubli;
	private Psicologo psicologo;
	private Publicacion publicacion;

	public PsicPubl() {
	}

	public PsicPubl(Psicologo psicologo, Publicacion publicacion) {
		this.psicologo = psicologo;
		this.publicacion = publicacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpsic_publi", unique = true, nullable = false)
	public Integer getIdpsicPubli() {
		return this.idpsicPubli;
	}

	public void setIdpsicPubli(Integer idpsicPubli) {
		this.idpsicPubli = idpsicPubli;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario", nullable = false)
	public Psicologo getPsicologo() {
		return this.psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpublicacion", nullable = false)
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}
