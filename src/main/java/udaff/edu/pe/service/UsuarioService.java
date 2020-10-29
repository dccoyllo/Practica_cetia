package udaff.edu.pe.service;

import udaff.edu.pe.entities.Usuario;

public interface UsuarioService {
	
	public boolean createUsuario(Usuario usuario);
	public Usuario readUsuario(int usuario_id);
	public boolean updateUsuario(Usuario usuario);

}
