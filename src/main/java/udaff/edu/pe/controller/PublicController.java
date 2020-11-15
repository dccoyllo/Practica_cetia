package udaff.edu.pe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import udaff.edu.pe.entities.Rol;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.service.PublicService;

@Controller
public class PublicController {
	@Autowired
	private PublicService pService;
	
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		 Usuario user = (Usuario) session.getAttribute("user");
		if(user != null) {
			model.addAttribute("user_nombre", user.getCuenta());
			System.out.println(user.getCuenta());
		}
		System.out.println(pService.getAllPublicacion());
//		model.addAttribute("publicaciones", pService.getAllPublicacion());

//		System.out.println(pService.getAllPublicacion());
//		System.out.println(pService.getAllActividad());
		return "public/home/index";
	}

	@GetMapping("/servicios")
	public String servicios(Model model) {
		model.addAttribute("servicios", pService.getAllServicio());
		System.out.println(pService.getAllServicio());
		return "public/servicios";
	}
	
	@GetMapping("/servicio")
	public String servicio(Model model, @RequestParam int id) {
		model.addAttribute("servicio", pService.getServicioId(id));
		return "public/detalleServicio";
	}

	@GetMapping("/psicologos")
	public String psicologos(Model model) {
		model.addAttribute("psicologos", pService.getAllPsicologo());
		System.out.println(pService.getAllPsicologo());
		return "public/psicologos";
	}

	@GetMapping("/contactenos")
	public String contactenos() {

		return "public/contact";
	}

	@GetMapping("/login")
	public String login() {

		return "public/login";
	}

	@PostMapping("/login")
	public String dataLogin(HttpServletRequest request, @RequestParam String cuenta, @RequestParam String password,
			Model model) {
		
		System.out.println(pService.getLogin(cuenta, password));
		if (pService.getLogin(cuenta, password) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", pService.getUsuarioId(pService.getLogin(cuenta, password).getId().getUserId()));
			return "redirect:/";
		} else {
			model.addAttribute("cuenta", cuenta);
			model.addAttribute("password", password);
			model.addAttribute("acceso", false);
			return "public/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/crear-cuenta")
	public String newlogin() {
		return "public/newlogin";
	}

	@PostMapping("/crear-cuenta")
	public String dataNewLogin(@RequestParam String cuenta, @RequestParam String email, @RequestParam String password,
			Model model) {
		Usuario usuario = new Usuario();
		usuario.setCuenta(cuenta);
		usuario.setCorreo(email);
		usuario.setClave(password);
//		newU.setNombre("");
//		newU.setApellido("");
//		newU.setEdad(0);
//		newU.setDni(0);
		Rol rol = new Rol();
		rol.setIdrol(1);
		usuario.setRol(rol);

		model.addAttribute("cuenta", cuenta);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		try {
			pService.createUsuario(usuario);
			model.addAttribute("estado", true);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("estado", false);
		}
//		if (uService.createUsuario(newU))
//			model.addAttribute("estado", true);
//		else
//			model.addAttribute("estado", false);

		return "public/newlogin";
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
