package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table (name = "investigadores")
public class Investigador {
	
	@Id
	private String dni;
	private String nombre_apellidos;
	private String dni_profesor;
	
	@ManyToOne
    @JoinColumn(name="id_facultad")
	private List<Facultad> facultad;
	
	@OneToMany
    @JoinColumn(name="dni_investigador")
	private List<Investigador> investigador;
	
	  public Investigador() {
	    }
	  
	    public Investigador(String dni, String nombre_apellidos, String dni_profesor, List<Facultad> facultad) {
	    	this.dni = dni;
	        this.nombre_apellidos = nombre_apellidos;
	        this.dni_profesor = dni_profesor;	 
	        this.facultad = facultad;
	    }

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNombre_apellidos() {
			return nombre_apellidos;
		}

		public void setNombre_apellidos(String nombre_apellidos) {
			this.nombre_apellidos = nombre_apellidos;
		}

		public String getDni_profesor() {
			return dni_profesor;
		}

		public void setDni_profesor(String dni_profesor) {
			this.dni_profesor = dni_profesor;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Facultad")
		public List<Facultad> getFacultad() {
			return facultad;
		}

		public void setFacultad(List<Facultad> facultad) {
			this.facultad = facultad;
		}

}