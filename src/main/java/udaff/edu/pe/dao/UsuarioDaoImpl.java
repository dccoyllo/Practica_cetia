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
