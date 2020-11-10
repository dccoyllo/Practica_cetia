package udaff.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.Usuario;

@Repository
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Usuario> getAllUsuario() {
		// TODO Auto-generated method stub
		return em.createQuery("From Usuario where rol.idrol not in (3,2)", Usuario.class).getResultList();
	}

	@Override
	public Usuario getUsuarioId(int usuario_id) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, usuario_id);
	}

	@Override
	public boolean deleteUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.remove(usuario);
		return true;
	}

	@Override
	public List<Psicologo> getAllPsicologo() {
		// TODO Auto-generated method stub
		return em.createQuery("From Psicologo", Psicologo.class).getResultList();
	}

	@Override
	public boolean createPsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		em.persist(psicologo);
		return true;
	}

	@Override
	public Psicologo getPsicologoId(int psicologo_id) {
		// TODO Auto-generated method stub
		return em.find(Psicologo.class, psicologo_id);
	}

	@Override
	public boolean deletePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		em.remove(psicologo);
		return true;
	}

	@Override
	public List<Servicio> getAllServicio() {
		// TODO Auto-generated method stub
		return em.createQuery("From Servicio", Servicio.class).getResultList();
	}

	@Override
	public boolean createServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		em.persist(servicio);
		return true;
	}

	@Override
	public Servicio getServicioId(int servicio_id) {
		// TODO Auto-generated method stub
		return em.find(Servicio.class, servicio_id);
	}

	@Override
	public boolean deleteServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		em.remove(servicio);
		return true;
	}
	
}
