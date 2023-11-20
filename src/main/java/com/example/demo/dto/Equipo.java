package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table (name = "equipos")
public class Equipo {
	
	@Id
	private String num_serie;
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="num_serie")
	@JsonIgnore
	private List<Reserva> reservas;
	
	@ManyToOne
    @JoinColumn(name="id_facultad")
	private List<Facultad> facultad;
	
	  public Equipo() {
	    }
	  
	    public Equipo(String num_serie, String nombre, List<Facultad> facultad) {
	    	this.num_serie = num_serie;
	        this.nombre = nombre;	 
	        this.facultad = facultad;
	    }

		public String getNum_serie() {
			return num_serie;
		}

		public void setNum_serie(String num_serie) {
			this.num_serie = num_serie;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
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