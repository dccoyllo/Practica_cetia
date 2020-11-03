package udaff.edu.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.PsicologoDao;
import udaff.edu.pe.entities.Psicologo;
@Service
@Transactional
public class PsicologoServiceImpl implements PsicologoService {
	@Autowired
	private PsicologoDao pDao;

	@Override
	public boolean createPsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return pDao.createPsicologo(psicologo);
	}

	@Override
	public boolean updatePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return pDao.updatePsicologo(psicologo);
	}

	@Override
	public boolean deletePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return pDao.deletePsicologo(psicologo);
	}

}
