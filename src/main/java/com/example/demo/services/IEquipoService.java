package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Equipo;


public interface IEquipoService {
	
		//Listar todos
		public List<Equipo> listarEquipos();
		
		//Listar por id
		public Optional<Equipo> getEquipoXID(String num_serie); 
		
		//Guardar
		public Equipo guardarEquipo(Equipo equipo);
		
		//Actualizar
		public Equipo actualizarEquipo(Equipo equipo);
		
		//Eliminar
		public void eliminarEquipo(String num_serie);

}