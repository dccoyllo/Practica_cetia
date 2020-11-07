package udaff.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import udaff.edu.pe.service.AdminService;

@Controller
@RequestMapping("/a")
public class AdminController {
	@Autowired
	private AdminService aService;
	
	@GetMapping("/usuarios")
	public String getAllUsuarios() {
		System.out.println(aService.getAllUsuario().size());
		return "private/admin/usuarios";
	}
	
	@GetMapping("/psicologos")
	public String getAllPsicologos() {
		System.out.println(aService.getAllPsicologo().size());
		return "private/admin/psicologos";
	}
	
	@GetMapping("/servicios")
	public String getAllServicios() {
		System.out.println(aService.getAllServicio().size());
		return "private/admin/servicios";
	}
}
