package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;


@Service
public class FacultadService implements IFacultadService{
	
	@Autowired
	IFacultadDAO iFacultadDAO;

		//Listar todos
		public List<Facultad> listarFacultades(){
			return iFacultadDAO.findAll();
		};
		
		//Listar por id
		public Facultad facultadXID(Integer id) {
			return iFacultadDAO.findById(id).get();
		}; 
		
		//Guardar
		public Facultad guardarFacultad(Facultad facultad) {
			return iFacultadDAO.save(facultad);
		};
		
		//Actualizar
		public Facultad actualizarFacultad(Facultad facultad) {
			return iFacultadDAO.save(facultad);
		};
		
		//Eliminar
		public void eliminarFacultad(Integer id) {
			iFacultadDAO.deleteById(id);
		}		

}