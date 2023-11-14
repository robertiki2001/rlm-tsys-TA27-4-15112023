package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Reserva;


public interface IReservaService {
	
		//Listar todos
		public List<Reserva> listarReservas();
		
		//Listar por id
		public Reserva reservaXID(Integer id); 
		
		//Guardar
		public Reserva guardarReserva(Reserva reserva);
		
		//Actualizar
		public Reserva actualizarReserva(Reserva reserva);
		
		//Eliminar
		public void eliminarReserva(Integer id);

}