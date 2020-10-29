package udaff.edu.pe.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean createUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			em.persist(usuario);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Usuario readUsuario(int usuario_id) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, usuario_id);
	}

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
	

}
