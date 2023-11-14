package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;


@Service
public class EquipoService implements IEquipoService{
	
	@Autowired
	IEquipoDAO iEquipoDAO;

		//Listar todos
		public List<Equipo> listarEquipos(){
			return iEquipoDAO.findAll();
		};
			
		//Listar por id
		public Optional<Equipo> getEquipoXID(String id) {
		    return iEquipoDAO.findById(id);
		}
		
		//Guardar
		public Equipo guardarEquipo(Equipo equipo) {
			return iEquipoDAO.save(equipo);
		};
		
		//Actualizar
		public Equipo actualizarEquipo(Equipo equipo) {
			return iEquipoDAO.save(equipo);
		};
		
		//Eliminar
		public void eliminarEquipo(String id) {
			iEquipoDAO.deleteById(id);
		}		

}