package udaff.edu.pe.dao;

import java.util.List;

import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.TipoPublicacion;
import udaff.edu.pe.entities.Usuario;

public interface PsicologoDao {
	public Psicologo getPsicolog(Usuario usuario);
	public boolean updatePsicologo(Psicologo psicologo);
	
	public boolean createServicio(Servicio servicio);
	public boolean updateServicio(Servicio servicio);
	public boolean deleteServicio(Servicio servicio);
	
	public List<Publicacion> getAllPublicacionPsicologo(Psicologo psicologo);
	
	public List<TipoPublicacion> getAllTipoPublicacion();
	public TipoPublicacion getTipoPublicacionId(int tipoPublicacion_id);
	public boolean createPublicacion(Publicacion publicacion);
	public Publicacion getPublicacionId(int publicacion_id);
	public boolean updatePublicacion(Publicacion publicacion);
	public boolean deletePublicacion(Publicacion publicacion);
	
	
	public List<Reservacion> getAllReservacion(String atencion);
	public Reservacion getReservacionId(int reservacion_id);
	public boolean updateReservacionAtendido(Reservacion reservacion);
	public boolean deleteReservacionAtendido(Reservacion reservacion);
	
}
