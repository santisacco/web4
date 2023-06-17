package com.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.io.Serializable;
import javax.inject.Named;


import com.capa2LogicaNegocio.Usuario;
import com.capa2LogicaNegocio.GestionUsuarioService;

import javax.enterprise.context.SessionScoped;	//JEE8
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value="gestionUsuario")		//JEE8
@SessionScoped				        //JEE8
public class GestionUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	GestionUsuarioService gestionUsuarioService;

	Long id;
	private Usuario usuarioSeleccionado;
	
	public GestionUsuarioBean() {
		super();
	}
	@PostConstruct
	public void init() {
		id=0l;
		
	}
	
	//se ejecuta antes de desplegar la vista
	public void preRenderViewListener() {
		//si id ==null o id ==0 comenzamos editando un registro nuevo
		if (id==null || id==0) {
			usuarioSeleccionado = new Usuario();
		} else {
			usuarioSeleccionado = gestionUsuarioService.buscarUsuario(id);
		}
		
	}
	
	//Pasar a modo 
	public String guardarCambios() {
		
		if (usuarioSeleccionado.getId()==null) {
			
			Usuario usuarioNuevo;
			usuarioNuevo = (Usuario) gestionUsuarioService.agregarUsuario(usuarioSeleccionado);
			
			//mensaje de actualizacion correcta
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado un nuevo usuario con id:" + usuarioNuevo.getId().toString(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			
			return "Usuarios";
			
		} else  { //habia id entonces estamos actualizando

			gestionUsuarioService.actualizarUsuario(usuarioSeleccionado);

			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado el usuario.",""));
			return "Usuarios";
		}
	}
	
	public String eliminarUsuario() {
		gestionUsuarioService.eliminarUsuario(usuarioSeleccionado);
		
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminó el usuario", "");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		
		return "Usuarios";
	}
	
	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}
	
	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
