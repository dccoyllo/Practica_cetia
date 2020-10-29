package udaff.edu.pe.dao;

import udaff.edu.pe.entities.Usuario;

public interface UsuarioDao {
	
	public boolean createUsuario(Usuario usuario);
	public Usuario readUsuario(int usuario_id);
	public boolean updateUsuario(Usuario usuario);
}
