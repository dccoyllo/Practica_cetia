package udaff.edu.pe.service;

import udaff.edu.pe.entities.Psicologo;

public interface PsicologoService {

	public boolean createPsicologo(Psicologo psicologo);
	public Psicologo readPsicologo(int psicologo_id);
	public boolean updatePsicologo(Psicologo psicologo);
	public boolean deletePsicologo(Psicologo psicologo);
}
