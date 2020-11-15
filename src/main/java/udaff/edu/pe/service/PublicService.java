package udaff.edu.pe.service;

import java.util.List;

import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.Usuario;

public interface PublicService {

	public List<Psicologo> getAllPsicologo();
	public List<Publicacion> getAllPublicacion();
	public List<Publicacion> getAllActividad();
	
	public List<Servicio> getAllServicio();
	public Servicio getServicioId(int servicio_id);
	public Login getLogin(String cuenta, String clave);
	public Usuario getUsuarioId(int usuario_id);
	public boolean createUsuario(Usuario usuario);
}
