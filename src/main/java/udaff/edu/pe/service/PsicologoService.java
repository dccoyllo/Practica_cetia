package udaff.edu.pe.service;

import java.util.List;

import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.TipoPublicacion;

public interface PsicologoService {
	
	public boolean updatePsicologo(Psicologo psicologo);
	
	public boolean createServicio(Servicio servicio);
	public boolean updateServicio(Servicio servicio);
	public boolean deleteServicio(Servicio servicio);
	
	public List<TipoPublicacion> getAllTipoPublicacion();
	public TipoPublicacion getTipoPublicacionId(int tipoPublicacion_id);
	public boolean createPublicacion(Publicacion publicacion);
	public Publicacion getPublicacionId(int publicacion_id);
	public boolean updatePublicacion(Publicacion publicacion);
	public boolean deletePublicacion(Publicacion publicacion);
	
	public List<Reservacion> getAllReservacion();
	public Reservacion getReservacionId(int reservacion_id);
	public boolean updateReservacionAtendido(Reservacion reservacion);
	public boolean deleteReservacionAtendido(Reservacion reservacion);
}
