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
import udaff.edu.pe.entities.Rol;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.service.AdminService;

@Controller
@RequestMapping("/a")
public class AdminController {
	@Autowired
	private AdminService aService;

	@GetMapping("/usuarios")
	public String getAllUsuarios(Model model) {
		model.addAttribute("usuarios", aService.getAllUsuario());
		model.addAttribute("psicologos", aService.getAllPsicologo());
		return "private/admin/usuarios";
	}

	@GetMapping("/servicios")
	public String getAllServicios(Model model) {
		model.addAttribute("servicios", aService.getAllServicio());
		return "private/admin/servicios";
	}

//	@DeleteMapping("/delete-user/{usuario_id}")
	@PostMapping("/delete-user")
	public String deleteUser(Model model, @RequestParam int usuario_id) {
		System.out.println(usuario_id);
//		model.addAttribute("delete", aService.deleteUsuario(aService.getUsuarioId(usuario_id)));
		aService.deleteUsuario(aService.getUsuarioId(usuario_id));
		return "redirect:/a/usuarios";
	}

	@PostMapping("/create-psicologo")
	public String createPsicologo(@RequestParam int usuario_id) {
		Usuario user = aService.getUsuarioId(usuario_id);
		Rol rol = new Rol();
		rol.setIdrol(2);
		user.setRol(rol);
		aService.updateUsuario(user);

		Psicologo psi = new Psicologo(user, "Psicologo");
		aService.createPsicologo(psi);
		System.out.println(user.getRol().getIdrol());
		return "redirect:/a/usuarios";
	}

	@PostMapping("/delete-psicologo")
	public String deletePsicologo(Model model, @RequestParam int psicologo_id) {
		Usuario user = aService.getUsuarioId(psicologo_id);
		Rol rol = new Rol();
		rol.setIdrol(1);
		user.setRol(rol);
		aService.updateUsuario(user);

		aService.deletePsicologo(aService.getPsicologoId(psicologo_id));
		return "redirect:/a/usuarios";
	}

	@PostMapping("/create-servicio")
	public String createServicio(Model model, HttpServletRequest request, @RequestParam double precio,
			@RequestParam String descripcion, @RequestParam String titulo, @RequestParam String tipo,
			@RequestParam String imagen) {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		udaff.edu.pe.entities.Servicio ser = new udaff.edu.pe.entities.Servicio();
		ser.setPrecio(precio);
		ser.setDescripcion(descripcion);
		ser.setTitulo(titulo);
		ser.setTipo(tipo);
		ser.setImagen(imagen);
		ser.setUsuario(usuario);
		aService.createServicio(ser);
		return "redirect:/a/servicios";
	}

	@GetMapping("/update-servicio")
	public String Servicio(Model model, @RequestParam int id) {
		model.addAttribute("servicio", aService.getServicioId(id));
		return "private/admin/updateServicio";
	}

	@PostMapping("/update-servicio")
	public String updateServicio(Model model, @RequestParam int servicio_id, @RequestParam double precio,
			@RequestParam String descripcion, @RequestParam String titulo, @RequestParam String tipo,
			@RequestParam String imagen) {
		udaff.edu.pe.entities.Servicio ser = aService.getServicioId(servicio_id);
		ser.setPrecio(precio);
		ser.setDescripcion(descripcion);
		ser.setTitulo(titulo);
		ser.setTipo(tipo);
		ser.setImagen(imagen);

		return "redirect:/a/update-servicio?id=" + servicio_id + "&cambio=" + aService.updateServicio(ser);
	}

	@PostMapping("/delete-servicio")
	public String deleteServicio(Model model, @RequestParam int servicio_id) {
		model.addAttribute("delete", aService.deleteServicio(aService.getServicioId(servicio_id)));
		return "redirect:/a/servicios";
	}
}
