package udaff.edu.pe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import udaff.edu.pe.entities.Psicologo;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.service.PsicologoService;

@Controller
@RequestMapping("/p")
public class PsicologoController {
	
	@Autowired
	private PsicologoService pService;

	@PostMapping("/perfil")
	public String createPost(Model model, HttpServletRequest request, @RequestParam String psi_imagen,
			@RequestParam String psi_especialidad) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("user");
		
		Psicologo psi = user.getPsicologo();
		psi.setUsuario(user);
		psi.setImagen(psi_imagen);
		psi.setEspecialidad(psi_especialidad);
		
		if (pService.updatePsicologo(psi))
			model.addAttribute("msgp", "correcto");
		else
			model.addAttribute("msgp", "incorrecto");

		return "private/user/perfil";
	}
	@GetMapping("/reservacion")
	public String reservacion() {
		
		return "private/psicologo/reservacion";
	}
	
	@GetMapping("/tus-post")
	public String tusPost() {
		
		return "private/psicologo/tusPost";
	}
	
	@GetMapping("/tus-servicios")
	public String tusServicio() {
		
		return "private/psicologo/tusServicios";
	}
}
