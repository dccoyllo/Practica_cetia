package udaff.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.UsuarioDao;
import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDao uDao;

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return uDao.updateUsuario(usuario);
	}

	@Override
	public List<Reservacion> getAllReservacionUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return uDao.getAllReservacionUsuario(usuario);
	}

	@Override
	public boolean updateReservacion(Reservacion reservacion) {
		// TODO Auto-generated method stub
		return uDao.updateReservacion(reservacion);
	}

	@Override
	public Reservacion getReservacionId(int reservacion_id) {
		// TODO Auto-generated method stub
		return uDao.getReservacionId(reservacion_id);
	}

	@Override
	public boolean createReservacion(Reservacion reservacion) {
		// TODO Auto-generated method stub
		return uDao.createReservacion(reservacion);
	}

}
