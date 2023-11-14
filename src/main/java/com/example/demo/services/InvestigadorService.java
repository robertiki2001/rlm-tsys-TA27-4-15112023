package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;


@Service
public class InvestigadorService implements IInvestigadorService{
	
	@Autowired
	IInvestigadorDAO iInvestigadorDAO;

		//Listar todos
		public List<Investigador> listarInvestigadores(){
			return iInvestigadorDAO.findAll();
		};
			
		//Listar por id
		public Optional<Investigador> getInvestigadorXID(String id) {
		    return iInvestigadorDAO.findById(id);
		}
		
		//Guardar
		public Investigador guardarInvestigador(Investigador investigador) {
			return iInvestigadorDAO.save(investigador);
		};
		
		//Actualizar
		public Investigador actualizarInvestigador(Investigador investigador) {
			return iInvestigadorDAO.save(investigador);
		};
		
		//Eliminar
		public void eliminarInvestigador(String id) {
			iInvestigadorDAO.deleteById(id);
		}		

}