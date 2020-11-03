package udaff.edu.pe.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Servicio;

@Repository
public class PublicDaoImpl implements PublicDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Psicologo> getAllPsicologo() {
		// TODO Auto-generated method stub
		return em.createQuery("From Psicologo", Psicologo.class).getResultList();
	}

	@Override
	public List<Publicacion> getAllPublicacion() {
		// TODO Auto-generated method stub
		return em.createQuery("From Publicacion", Publicacion.class).getResultList();
	}


	@Override
	public List<Servicio> getAllServicio() {
		// TODO Auto-generated method stub
		return em.createQuery("From Servicio", Servicio.class).getResultList();
	}

	@Override
	public Login getLogin(String cuenta, String clave) {
		// TODO Auto-generated method stub
		try {
			return em.createQuery("From Login where id.userCuenta =: cuenta and id.userClave =: clave", Login.class).setParameter("cuenta", cuenta).setParameter("clave", clave).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
