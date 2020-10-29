package udaff.edu.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.UsuarioDao;
import udaff.edu.pe.entities.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDao uDao;

	@Override
	public boolean createUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return uDao.createUsuario(usuario);
	}

	@Override
	public Usuario readUsuario(int usuario_id) {
		// TODO Auto-generated method stub
		return uDao.readUsuario(usuario_id);
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return uDao.updateUsuario(usuario);
	}



}
