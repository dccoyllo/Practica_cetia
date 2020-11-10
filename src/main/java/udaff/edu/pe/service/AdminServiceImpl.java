package udaff.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.AdminDao;
import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.Usuario;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao aDao;
	
	@Override
	public List<Usuario> getAllUsuario() {
		// TODO Auto-generated method stub
		return aDao.getAllUsuario();
	}

	@Override
	public Usuario getUsuarioId(int usuario_id) {
		// TODO Auto-generated method stub
		return aDao.getUsuarioId(usuario_id);
	}

	@Override
	public boolean deleteUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return aDao.deleteUsuario(usuario);
	}

	@Override
	public List<Psicologo> getAllPsicologo() {
		// TODO Auto-generated method stub
		return aDao.getAllPsicologo();
	}

	@Override
	public boolean createPsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return aDao.createPsicologo(psicologo);
	}

	@Override
	public Psicologo getPsicologoId(int psicologo_id) {
		// TODO Auto-generated method stub
		return aDao.getPsicologoId(psicologo_id);
	}

	@Override
	public boolean deletePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return aDao.deletePsicologo(psicologo);
	}

	@Override
	public List<Servicio> getAllServicio() {
		// TODO Auto-generated method stub
		return aDao.getAllServicio();
	}

	@Override
	public boolean createServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return aDao.createServicio(servicio);
	}

	@Override
	public Servicio getServicioId(int servicio_id) {
		// TODO Auto-generated method stub
		return aDao.getServicioId(servicio_id);
	}

	@Override
	public boolean deleteServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return aDao.deleteServicio(servicio);
	}

}
