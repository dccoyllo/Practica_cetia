package udaff.edu.pe.dao;

import java.util.List;

import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Usuario;

public interface UsuarioDao {
	
	public boolean updateUsuario(Usuario usuario);
	public List<Reservacion> getAllReservacionUsuario(Usuario usuario);
	public Reservacion getReservacionId(int reservacion_id);
	public boolean updateReservacion(Reservacion reservacion);
	
}
