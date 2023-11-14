package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Investigador;


public interface IInvestigadorService {
	
		//Listar todos
		public List<Investigador> listarInvestigadores();
		
		//Listar por id
		public Optional<Investigador> getInvestigadorXID(String dni); 
		
		//Guardar
		public Investigador guardarInvestigador(Investigador investigador);
		
		//Actualizar
		public Investigador actualizarInvestigador(Investigador investigador);
		
		//Eliminar
		public void eliminarInvestigador(String dni);

}