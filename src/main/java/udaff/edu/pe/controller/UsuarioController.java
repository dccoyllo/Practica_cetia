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

import udaff.edu.pe.entities.Reservacion;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.service.UsuarioService;

@Controller
@RequestMapping("/u")
public class UsuarioController {
	@Autowired
	private UsuarioService uService;
	@GetMapping("/perfil")
	public String pagePerfil() {
		return "private/user/perfil";
	}
	
	@GetMapping("/mis-citas")
	public String pageMisCitas(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("user");
		
		model.addAttribute("reservaciones", uService.getAllReservacionUsuario(user));
		return "private/user/misCitas";
	}
	
	@PostMapping("/mis-citas")
	public String cancelacionReservacion(@RequestParam int reservacion_id) {
		Reservacion reservacion = uService.getReservacionId(reservacion_id);
		reservacion.setAtencion("cancelado");
		uService.updateReservacion(reservacion);
		return "redirect:/u/mis-citas";
	}

	@PostMapping("/perfil")
	public String updatePerfil(Model model, HttpServletRequest request, @RequestParam String user_nombre,
			@RequestParam String user_apellido, @RequestParam String user_correo, @RequestParam int user_dni,
			@RequestParam int user_edad, @RequestParam String user_clave) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("user");
		user.setNombre(user_nombre);
		user.setApellido(user_apellido);
		user.setCorreo(user_correo);
		user.setDni(user_dni);
		user.setEdad(user_edad);
		user.setClave(user_clave);
		if (uService.updateUsuario(user))
			model.addAttribute("msgu", "correcto");
		else
			model.addAttribute("msgu", "incorrecto");

		return "private/user/perfil";
	}
}
