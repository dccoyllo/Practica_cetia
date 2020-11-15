package udaff.edu.pe.controller;

import java.util.Date;

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
import udaff.edu.pe.entities.Publicacion;
import udaff.edu.pe.entities.TipoPublicacion;
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
	public String tusPost(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("user");
		Psicologo psi = pService.getPsicolog(user);
		model.addAttribute("tipo", pService.getAllTipoPublicacion());
		model.addAttribute("publicaciones", pService.getAllPublicacionPsicologo(psi));
		return "private/psicologo/tusPost";
	}
	
	@PostMapping("/create-post")
	public String createPublicacion(Model model, HttpServletRequest request, @RequestParam int tipoPublicacion_id ,@RequestParam String titulo, @RequestParam String imagen, @RequestParam String descripcion) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("user");
		Psicologo psi = pService.getPsicolog(user);
		TipoPublicacion tipoPublicacion = pService.getTipoPublicacionId(tipoPublicacion_id);
		Publicacion publicacion = new Publicacion();
		publicacion.setPsicologo(psi);
		publicacion.setTipoPublicacion(tipoPublicacion);
		publicacion.setTitulo(titulo);
		publicacion.setFecha(new Date());
		publicacion.setHora(new Date());
		publicacion.setImagen(imagen);
		publicacion.setDescripcion(descripcion);
		
		pService.createPublicacion(publicacion);
		return "redirect:/p/tus-post";
	}
	
	@GetMapping("/update-post")
	public String Publicacion(Model model, @RequestParam int id) {
		model.addAttribute("tipo", pService.getAllTipoPublicacion());
		
		model.addAttribute("publicacion", pService.getPublicacionId(id));
		return "private/psicologo/updatePost";
	}
	
	@PostMapping("/update-post")
	public String updatePublicacion(Model model, @RequestParam int publicacion_id, @RequestParam int tipoPublicacion_id
			, @RequestParam String titulo, @RequestParam String imagen, @RequestParam String descripcion) {
		
		
		Publicacion pub = pService.getPublicacionId(publicacion_id);
		TipoPublicacion tipoPublicacion = pService.getTipoPublicacionId(tipoPublicacion_id);
		pub.setImagen(imagen);
		pub.setTitulo(titulo);
		pub.setDescripcion(descripcion);
		pub.setTipoPublicacion(tipoPublicacion);

		return "redirect:/p/update-post?id="+publicacion_id+"&cambio="+pService.updatePublicacion(pub);
	}
	
	@PostMapping("/delete-post")
	public String deletePublicacion(@RequestParam int publicacion_id) {
		pService.deletePublicacion(pService.getPublicacionId(publicacion_id));
		return "redirect:/p/tus-post";
	}
	
	@GetMapping("/tus-servicios")
	public String tusServicio() {
		
		return "private/psicologo/tusServicios";
	}
}
