package com.bean;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;

import com.capa2LogicaNegocio.Usuario;
import com.capa2LogicaNegocio.GestionUsuarioService;


import javax.enterprise.context.SessionScoped;	//JEE8

@Named(value="gestionUsuarios")		//JEE8
@SessionScoped				        //JEE8
public class GestionUsuariosBean implements Serializable{
	
	@EJB
	GestionUsuarioService gestionUsuarioService;

	private static final long serialVersionUID = 1L;
	
	private String criterioNombre;
	
	private List<Usuario> usuariosSeleccionados;
	private Usuario usuarioSeleccionado;
	
	public GestionUsuariosBean() {
		super();
	}
	
	public String seleccionarUsuarios()  {
		usuariosSeleccionados = gestionUsuarioService.seleccionarUsuarios(criterioNombre);
		return "";
	}
	
	
	public String verDatosUsuario() {
		return usuarioSeleccionado.toString();
	}
	
	public String getCriterioNombre() {
		return criterioNombre;
	}
	
	public void setCriterioNombre(String criterioNombre) {
		this.criterioNombre = criterioNombre;
	}
	
	public List<Usuario> getUsuariosSeleccionados() {
		return usuariosSeleccionados;
	}
	public void setUsuariosSeleccionados(List<Usuario> usuariosSeleccionados) {
		this.usuariosSeleccionados = usuariosSeleccionados;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
}
