package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table (name = "facultades")
public class Facultad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
	private List<Investigador> investigador;
	
	@OneToMany
    @JoinColumn(name="id")
	private List<Equipo> equipo;
	
	  public Facultad() {
	    }
	  
	    public Facultad(int id, String nombre, List<Investigador> investigador, List<Equipo> equipo) {
	    	this.id = id;
	        this.nombre = nombre;	 
	        this.investigador = investigador;
	        this.equipo = equipo;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
		public List<Investigador> getInvestigador() {
			return investigador;
		}

		public void setInvestigador(List<Investigador> investigador) {
			this.investigador = investigador;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
		public List<Equipo> getEquipo() {
			return equipo;
		}

		public void setEquipo(List<Equipo> equipo) {
			this.equipo = equipo;
		}

		
		

	   
}