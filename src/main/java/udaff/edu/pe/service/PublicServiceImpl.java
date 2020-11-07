package udaff.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.PublicDao;
import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.Usuario;

@Service
@Transactional
public class PublicServiceImpl implements PublicService {
	@Autowired
	private PublicDao pDao;
	
	@Override
	public List<Psicologo> getAllPsicologo() {
		// TODO Auto-generated method stub
		return pDao.getAllPsicologo();
	}

	@Override
	public List<Publicacion> getAllPublicacion() {
		// TODO Auto-generated method stub
		return pDao.getAllPublicacion();
	}


	@Override
	public List<Servicio> getAllServicio() {
		// TODO Auto-generated method stub
		return pDao.getAllServicio();
	}

	@Override
	public Login getLogin(String cuenta, String clave) {
		// TODO Auto-generated method stub
		return pDao.getLogin(cuenta, clave);
	}

	@Override
	public boolean createUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return pDao.createUsuario(usuario);
	}

	@Override
	public Usuario getUsuarioId(int usuario_id) {
		// TODO Auto-generated method stub
		return pDao.getUsuarioId(usuario_id);
	}

	@Override
	public List<Publicacion> getAllActividad() {
		// TODO Auto-generated method stub
		return pDao.getAllActividad();
	}

}
