package udaff.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.PsicologoDao;
import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.TipoPublicacion;
import udaff.edu.pe.entities.Usuario;
@Service
@Transactional
public class PsicologoServiceImpl implements PsicologoService {
	@Autowired
	private PsicologoDao pDao;

	@Override
	public boolean updatePsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return pDao.updatePsicologo(psicologo);
	}

	@Override
	public boolean createServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return pDao.createServicio(servicio);
	}

	@Override
	public boolean updateServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return pDao.updateServicio(servicio);
	}

	@Override
	public boolean deleteServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return pDao.deleteServicio(servicio);
	}

	@Override
	public List<TipoPublicacion> getAllTipoPublicacion() {
		// TODO Auto-generated method stub
		return pDao.getAllTipoPublicacion();
	}

	@Override
	public TipoPublicacion getTipoPublicacionId(int tipoPublicacion_id) {
		// TODO Auto-generated method stub
		return pDao.getTipoPublicacionId(tipoPublicacion_id);
	}

	@Override
	public boolean createPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		return pDao.createPublicacion(publicacion);
	}

	@Override
	public Publicacion getPublicacionId(int publicacion_id) {
		// TODO Auto-generated method stub
		return pDao.getPublicacionId(publicacion_id);
	}

	@Override
	public boolean updatePublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		return pDao.updatePublicacion(publicacion);
	}

	@Override
	public boolean deletePublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		return pDao.deletePublicacion(publicacion);
	}

	@Override
	public List<Reservacion> getAllReservacion(String atencion) {
		// TODO Auto-generated method stub
		return pDao.getAllReservacion(atencion);
	}

	@Override
	public Reservacion getReservacionId(int reservacion_id) {
		// TODO Auto-generated method stub
		return pDao.getReservacionId(reservacion_id);
	}

	@Override
	public boolean updateReservacionAtendido(Reservacion reservacion) {
		// TODO Auto-generated method stub
		return pDao.updateReservacionAtendido(reservacion);
	}

	@Override
	public boolean deleteReservacionAtendido(Reservacion reservacion) {
		// TODO Auto-generated method stub
		return pDao.deleteReservacionAtendido(reservacion);
	}

	@Override
	public List<Publicacion> getAllPublicacionPsicologo(Psicologo psicologo) {
		// TODO Auto-generated method stub
		return pDao.getAllPublicacionPsicologo(psicologo);
	}

	@Override
	public Psicologo getPsicolog(Usuario usuario) {
		// TODO Auto-generated method stub
		return pDao.getPsicolog(usuario);
	}

}
