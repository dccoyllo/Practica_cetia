package udaff.edu.pe.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Psicologo;

@Repository
public class PsicologoDaoImpl implements PsicologoDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean createPsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		try {
			em.persist(psicologo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updatePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		try {
			em.merge(psicologo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deletePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		try {
			em.remove(psicologo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
