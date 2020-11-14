package udaff.edu.pe.service;

import java.util.List;

import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Servicio;
import udaff.edu.pe.entities.Usuario;

public interface AdminService {

	public List<Usuario> getAllUsuario();
	public Usuario getUsuarioId(int usuario_id);
	public boolean updateUsuario(Usuario usuario);
	public boolean deleteUsuario(Usuario usuario);
	
	public List<Psicologo> getAllPsicologo();
	public boolean createPsicologo(Psicologo psicologo);
	public Psicologo getPsicologoId(int psicologo_id);
	public boolean deletePsicologo(Psicologo psicologo);
	
	public List<Servicio> getAllServicio();
	public boolean createServicio(Servicio servicio);
	public Servicio getServicioId(int servicio_id);
	public boolean updateServicio(Servicio servicio);
	public boolean deleteServicio(Servicio servicio);
}
