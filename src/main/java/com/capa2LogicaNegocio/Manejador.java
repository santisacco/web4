package com.capa2LogicaNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;


@Named("test")
@SessionScoped
public class Manejador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuarioSeleccionado;
	
	private ArrayList<Usuario> usuariosSistema = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		usuarioSeleccionado = new Usuario();
	}
	
	public void agregarUsuario() {
		usuarioSeleccionado.setId(nuevoId());
		usuariosSistema.add(usuarioSeleccionado);
		System.out.println("El usuario con el nombre " + usuarioSeleccionado.getNombre() + " Fue creado");
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

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
	
}

//	public List<Usuario> seleccionarUsuarios() {
//		return usuariosSistema;
//	}
//
//	public List<Usuario> seleccionarUsuarios(String criterioNombre) {
//		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
//		if (criterioNombre == null || criterioNombre == "") {
//			return usuariosSistema;
//		} else {
//			for (Usuario usuario : usuariosSistema) {
//				if (criterioNombre.equals(usuario.getNombre())) {
//					listaUsuarios.add(usuario);
//				}
//			}
//		
//			return listaUsuarios;
//		}
//	}
//	
//	public Usuario buscarUsuario(Long id) {
//		Usuario usuario = new Usuario();
//		for (Usuario user : usuariosSistema) {
//			if (id == user.getId()) {
//				usuario = user;
//			}
//		}
//		return usuario;
//	}
	

//	public void actualizarUsuario(Usuario usuarioSeleccionado) {
//		usuariosSistema.forEach(u -> {
//			if (u.getId().equals(usuarioSeleccionado.getId())) {
//				u.setNombre(usuarioSeleccionado.getNombre());
//				u.setApellido(usuarioSeleccionado.getApellido());
//			}
//		});
//	}
//	
//	public void eliminarUsuario(Usuario usuarioSeleccionado) {
//		usuariosSistema.remove(usuarioSeleccionado);
//	}
//	

