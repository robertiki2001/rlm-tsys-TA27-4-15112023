package com.example.demo.dto;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table (name = "reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "dni_investigador")
	private Investigador investigador;

	@ManyToOne
	@JoinColumn(name="num_serie")
	private Equipo equipo;
	
	private Date comienzo;
	private Date fin;
	
	  public Reserva() {
	    }
	  
	    public Reserva(int id, Investigador investigador, Equipo equipo, Date comienzo, Date fin) {
	    	this.id = id;
	        this.investigador = investigador;
	        this.equipo = equipo;
	        this.comienzo = comienzo;
	        this.fin = fin;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Investigador getInvestigador() {
			return investigador;
		}

		public void setInvestigador(Investigador investigador) {
			this.investigador = investigador;
		}

		public Equipo getEquipo() {
			return equipo;
		}

		public void setEquipo(Equipo equipo) {
			this.equipo = equipo;
		}

		public Date getComienzo() {
			return comienzo;
		}

		public void setComienzo(Date comienzo) {
			this.comienzo = comienzo;
		}

		public Date getFin() {
			return fin;
		}

		public void setFin(Date fin) {
			this.fin = fin;
		}

}