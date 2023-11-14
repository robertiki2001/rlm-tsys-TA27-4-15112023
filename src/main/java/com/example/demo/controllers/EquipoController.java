package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Equipo;
import com.example.demo.services.EquipoService;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoService equipoService;

	@GetMapping("/equipos")
	public List<Equipo> listarEquipos() {
		return equipoService.listarEquipos();
	}
	
	@GetMapping("/equipo/{id}")
	public ResponseEntity<Equipo> equipoXID(@PathVariable(name = "num_serie") String num_serie) {
		Optional<Equipo> equipo = equipoService.getEquipoXID(num_serie);
		if (equipo.isPresent()) {
			return ResponseEntity.ok(equipo.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/equipo")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoService.guardarEquipo(equipo);
	}
	
	@PutMapping("/equipo/{id}")
	public ResponseEntity<Equipo> actualizarEquipo(@PathVariable(name = "num_serie") String num_serie, @RequestBody Equipo equipo) {

		Optional<Equipo> equipo_seleccionado = equipoService.getEquipoXID(num_serie);

	    if (equipo_seleccionado.isPresent()) {
	    	Equipo equipo_existente = equipo_seleccionado.get();
	    	 
	    	if (equipo.getNombre() != null) {
	    		equipo_existente.setNombre(equipo.getNombre());
		        }
	    	if (equipo.getNombre() != null) {
	    		equipo_existente.setFacultad(equipo.getFacultad());
		        }

	    	Equipo equipo_actualizado = equipoService.actualizarEquipo(equipo_existente);

	        return ResponseEntity.ok(equipo_actualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/equipo/{id}")
	public ResponseEntity<Void> eliminarEquipo(@PathVariable(name = "num_serie") String num_serie) {
		Optional<Equipo> equipo = equipoService.getEquipoXID(num_serie);
		if (equipo.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
