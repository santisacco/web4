package com.capa2LogicaNegocio;


public class Usuario {

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String fechaNac;
	

	public Usuario() {
		super();
	}
	
	public Usuario(Long id, String nombre, String apellido, String direccion, String fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.fechaNac = fechaNac;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
		
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
		
	}

	public String getFechaNac() {
		return fechaNac;
		
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
		
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
}
