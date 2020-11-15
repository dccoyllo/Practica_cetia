package udaff.edu.pe.service;

import java.util.List;

import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Usuario;

public interface UsuarioService {
	
	public boolean updateUsuario(Usuario usuario);
	public List<Reservacion> getAllReservacionUsuario(Usuario usuario);
	public Reservacion getReservacionId(int reservacion_id);
	public boolean createReservacion(Reservacion reservacion);
	public boolean updateReservacion(Reservacion reservacion);
}
