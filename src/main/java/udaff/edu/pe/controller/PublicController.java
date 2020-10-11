package udaff.edu.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

	@GetMapping("/")
	public String index() {
		return "public/home/index";
	}

	@GetMapping("/contactenos")
	public String contactenos() {

		return "public/contact";
	}

	@GetMapping("/login")
	public String login() {

		return "public/login";
	}

	@GetMapping("/setpaciente")
	public String createPaciente() {

		return "public/createpaciente";
	}

	@GetMapping("/setpsicologo")
	public String createPsicologo() {

		return "public/createpsicologo";
	}

	@GetMapping("/setformulario")
	public String createFormulario() {

		return "public/createformulario";
	}

	@GetMapping("/allpacientes")
	public String getAllPacientes() {

		return "public/allpacientes";
	}

	@GetMapping("/allformularios")
	public String getAllFormularios() {

		return "public/allformularios";
	}

	@GetMapping("/test")
	public String getFormulario(int id) {

		return "public/formulario";
	}

	@GetMapping("/psicologo")
	public String getPsicologo(int id) {

		return "public/psicologo";
	}

}
