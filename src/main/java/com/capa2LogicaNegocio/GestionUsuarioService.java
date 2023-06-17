package com.capa2LogicaNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class GestionUsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Usuario> usuariosSistema = new ArrayList<>();

	public List<Usuario> seleccionarUsuarios() {
		return usuariosSistema;
	}

	public List<Usuario> seleccionarUsuarios(String criterioNombre) {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if (criterioNombre == null || criterioNombre == "") {
			return usuariosSistema;
		} else {
			for (Usuario usuario : usuariosSistema) {
				if (criterioNombre.equals(usuario.getNombre())) {
					listaUsuarios.add(usuario);
				}
			}
		
			return listaUsuarios;
		}
	}
	
	public Usuario buscarUsuario(Long id) {
		Usuario usuario = new Usuario();
		for (Usuario user : usuariosSistema) {
			if (id == user.getId()) {
				usuario = user;
			}
		}
		return usuario;
	}
	
	public Usuario agregarUsuario(Usuario usuarioSeleccionado) {
		Usuario usuarioNuevo = usuarioSeleccionado;
		usuarioNuevo.setId(nuevoId());
		usuariosSistema.add(usuarioNuevo);
		return usuarioNuevo;
	}

	public void actualizarUsuario(Usuario usuarioSeleccionado) {
		usuariosSistema.forEach(u -> {
			if (u.getId().equals(usuarioSeleccionado.getId())) {
				u.setNombre(usuarioSeleccionado.getNombre());
				u.setApellido(usuarioSeleccionado.getApellido());
			}
		});
	}
	
	public void eliminarUsuario(Usuario usuarioSeleccionado) {
		usuariosSistema.remove(usuarioSeleccionado);
	}
	
	private Long nuevoId() {
		Long nuevoId = 1L;
		if (usuariosSistema.isEmpty()) {
			return nuevoId;
		} else {
			nuevoId = usuariosSistema.get(usuariosSistema.size() - 1).getId() + 1;
			return nuevoId;
		}
	}
}
