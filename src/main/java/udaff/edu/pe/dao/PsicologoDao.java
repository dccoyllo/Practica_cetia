package udaff.edu.pe.dao;

import udaff.edu.pe.entities.Psicologo;

public interface PsicologoDao {
	
	public boolean createPsicologo(Psicologo psicologo);
	
	public boolean updatePsicologo(Psicologo psicologo);
	public boolean deletePsicologo(Psicologo psicologo);
}
