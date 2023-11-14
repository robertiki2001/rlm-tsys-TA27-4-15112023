package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaService implements IReservaService{
	
	@Autowired
	IReservaDAO iReservaDAO;

		//Listar todos
		public List<Reserva> listarReservas(){
			return iReservaDAO.findAll();
		};
		
		//Listar por id
		public Reserva reservaXID(Integer id) {
			return iReservaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Reserva guardarReserva(Reserva reserva) {
			return iReservaDAO.save(reserva);
		};
		
		//Actualizar
		public Reserva actualizarReserva(Reserva reserva) {
			return iReservaDAO.save(reserva);
		};
		
		//Eliminar
		public void eliminarReserva(Integer id) {
			iReservaDAO.deleteById(id);
		}	

}