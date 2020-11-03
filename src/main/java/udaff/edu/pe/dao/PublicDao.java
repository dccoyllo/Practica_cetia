package udaff.edu.pe.dao;

import java.util.List;

import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.Servicio;

public interface PublicDao {

	public List<Psicologo> getAllPsicologo();
	public List<Publicacion> getAllPublicacion();
	
	public List<Servicio> getAllServicio();
	
	
	public Login getLogin(String cuenta, String clave);
}
