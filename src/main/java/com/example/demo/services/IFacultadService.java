package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Facultad;


public interface IFacultadService {
	
		//Listar todos
		public List<Facultad> listarFacultades();
		
		//Listar por id
		public Facultad facultadXID(Integer id); 
		
		//Guardar
		public Facultad guardarFacultad(Facultad facultad);
		
		//Actualizar
		public Facultad actualizarFacultad(Facultad facultad);
		
		//Eliminar
		public void eliminarFacultad(Integer id);

}