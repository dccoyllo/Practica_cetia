package udaff.edu.pe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import udaff.edu.pe.entities.Usuario;

@Controller
@RequestMapping("/p")
public class PsicologoController {
	
	@GetMapping("/tus-post")
	public String createPost(HttpServletRequest request) {
		HttpSession session = request.getSession();
		 Usuario user = (Usuario) session.getAttribute("user");
		 
		return "private/psicologo/tusPost";
	}
}
