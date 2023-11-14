package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Investigador;
import com.example.demo.services.InvestigadorService;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorService investigadorService;

	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores() {
		return investigadorService.listarInvestigadores();
	}
	
	@GetMapping("/investigador/{id}")
	public ResponseEntity<Investigador> equipoXID(@PathVariable(name = "dni") String dni) {
		Optional<Investigador> investigador = investigadorService.getInvestigadorXID(dni);
		if (investigador.isPresent()) {
			return ResponseEntity.ok(investigador.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/investigador")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorService.guardarInvestigador(investigador);
	}
	
	@PutMapping("/investigador/{id}")
	public ResponseEntity<Investigador> actualizarInvestigador(@PathVariable(name = "dni") String dni, @RequestBody Investigador investigador) {

		Optional<Investigador> investigador_seleccionado = investigadorService.getInvestigadorXID(dni);

	    if (investigador_seleccionado.isPresent()) {
	    	Investigador investigador_existente = investigador_seleccionado.get();
	    	 
	    	if (investigador.getNombre_apellidos() != null) {
	    		investigador_existente.setNombre_apellidos(investigador.getNombre_apellidos());
		        }
	    	if (investigador.getFacultad() != null) {
	    		investigador_existente.setFacultad(investigador.getFacultad());
		        }
	    	if (investigador.getDni_profesor() != null) {
	    		investigador_existente.setDni_profesor(investigador.getDni_profesor());
		        }

	    	Investigador investigador_actualizado = investigadorService.actualizarInvestigador(investigador_existente);

	        return ResponseEntity.ok(investigador_actualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/investigador/{id}")
	public ResponseEntity<Void> eliminarInvestigador(@PathVariable(name = "dni") String dni) {
		Optional<Investigador> equipo = investigadorService.getInvestigadorXID(dni);
		if (equipo.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
