package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public class UsuarioRepository {

	List<Usuario> usuarios;

	public UsuarioRepository() {	
		Usuario usr1 = new Usuario("Julio", 20);
		Usuario usr2 = new Usuario("Pedro", 21);
		Usuario usr3 = new Usuario("Ernan", 22);
		Usuario usr4 = new Usuario("Mario", 23);
		Usuario usr5 = new Usuario("Andres", 24);
		
		usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usr1);
		usuarios.add(usr2);
		usuarios.add(usr3);
		usuarios.add(usr4);
		usuarios.add(usr5);
	}
	
	public boolean crearUsuario(Usuario usuario) {
		usuarios.add(usuario);
		return true;
	}
	
	public boolean actualizarUsuario(Usuario usuario, String usuarioActualizar) {
		if(buscarUsuario(usuarioActualizar) != null) {
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getNombre().equals(usuarioActualizar)) {
					usuarios.remove(i);
					usuarios.add(i, usuario);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean eliminarUsuario(Usuario usuario) {
		if (usuarios.size() != 0) {
			usuarios.remove(usuario);
			return true;
		}
		return false;
	}
	
	public List<Usuario> listarUsuarios(){
		return this.usuarios;
	}
	
	public Usuario buscarUsuario(String nombreUsuario) {	
		for (Usuario usuario : usuarios) {
			if(usuario.getNombre().equals(nombreUsuario)) {
				return usuario;
			}
		}		
		return null;
	}
}
