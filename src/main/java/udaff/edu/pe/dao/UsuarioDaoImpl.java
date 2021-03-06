package udaff.edu.pe.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			em.merge(usuario);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Reservacion> getAllReservacionUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return em.createQuery("From Reservacion where usuario =: user", Reservacion.class).setParameter("user", usuario).getResultList();
	}

	@Override
	public boolean updateReservacion(Reservacion reservacion) {
		// TODO Auto-generated method stub
		em.merge(reservacion);
		return true;
	}

	@Override
	public Reservacion getReservacionId(int reservacion_id) {
		// TODO Auto-generated method stub
		return em.find(Reservacion.class, reservacion_id);
	}

	@Override
	public boolean createReservacion(Reservacion reservacion) {
		// TODO Auto-generated method stub
		em.persist(reservacion);
		return true;
	}
	

}
