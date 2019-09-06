
package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/crear", method = RequestMethod.POST)
	boolean crearUsuario(@RequestParam("nombre") String nombreUsuario, @RequestParam("edad") String edad) {
		return usuarioService.crearUsuario(nombreUsuario, edad);
	}

	@RequestMapping(path = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
	@RequestMapping(path = "/buscar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Usuario buscarUsuario(@RequestParam("nombre") String nombreUsuario) {
		return usuarioService.buscarUsuario(nombreUsuario);
	}
	
	@RequestMapping(path = "/modificar", method = RequestMethod.PATCH)
	boolean modificarUsuario(@RequestParam("nombre") String nombreUsuario, @RequestParam("edad") String edad, @RequestParam("nombreActualizar") String usuarioActualizar) {
		return usuarioService.modificarUsuario(nombreUsuario, edad, usuarioActualizar);
	}

	@RequestMapping(path = "/eliminar/{nombre}", method = RequestMethod.DELETE)
	boolean eliminarUsuario(@PathParam("nombre") String usuario) {
		return usuarioService.eliminarUsuario(usuario);
	}
}
