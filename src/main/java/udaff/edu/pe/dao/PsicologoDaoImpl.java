package udaff.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.TipoPublicacion;
import udaff.edu.pe.entities.Usuario;

@Repository
public class PsicologoDaoImpl implements PsicologoDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean updatePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		em.merge(psicologo);
		return true;
	}

	@Override
	public boolean createServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		em.persist(servicio);
		return true;
	}

	@Override
	public boolean updateServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		em.merge(servicio);
		return true;
	}

	@Override
	public boolean deleteServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		em.remove(servicio);
		return true;
	}

	@Override
	public List<TipoPublicacion> getAllTipoPublicacion() {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoPublicacion", TipoPublicacion.class).getResultList();
	}

	@Override
	public TipoPublicacion getTipoPublicacionId(int tipoPublicacion_id) {
		// TODO Auto-generated method stub
		return em.find(TipoPublicacion.class, tipoPublicacion_id);
	}

	@Override
	public boolean createPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		em.persist(publicacion);
		return true;
	}

	@Override
	public Publicacion getPublicacionId(int publicacion_id) {
		// TODO Auto-generated method stub
		return em.find(Publicacion.class, publicacion_id);
	}
	
	@Override
	public boolean updatePublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		em.merge(publicacion);
		return true;
	}

	@Override
	public boolean deletePublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		em.remove(publicacion);
		return true;
	}

	@Override
	public List<Reservacion> getAllReservacion() {
		// TODO Auto-generated method stub
		return em.createQuery("From Reservacion", Reservacion.class).getResultList();
	}

	@Override
	public Reservacion getReservacionId(int reservacion_id) {
		// TODO Auto-generated method stub
		return em.find(Reservacion.class, reservacion_id);
	}

	@Override
	public boolean updateReservacionAtendido(Reservacion reservacion) {
		// TODO Auto-generated method stub
		em.merge(reservacion);
		return true;
	}

	@Override
	public boolean deleteReservacionAtendido(Reservacion reservacion) {
		// TODO Auto-generated method stub
		em.remove(reservacion);
		return true;
	}

	@Override
	public List<Publicacion> getAllPublicacionPsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return em.createQuery("From Publicacion where psicologo =: psi order by hora desc", Publicacion.class).setParameter("psi", psicologo).getResultList();
	}

	@Override
	public Psicologo getPsicolog(Usuario usuario) {
		// TODO Auto-generated method stub
		return em.createQuery("From Psicologo where usuario =: user", Psicologo.class).setParameter("user", usuario).getSingleResult();
	}


}
