package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Facultad;
import com.example.demo.services.FacultadService;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadService facultadService;

	@GetMapping("/facultades")
	public List<Facultad> listarFacultades() {
		return facultadService.listarFacultades();
	}

	@GetMapping("/facultad/{id}")
	public Facultad facultadXID(@PathVariable(name = "id") Integer id) {
		return facultadService.facultadXID(id);
	}

	@PostMapping("/facultad")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadService.guardarFacultad(facultad);
	}

	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name = "id") Integer id, @RequestBody Facultad facultad) {

		Facultad facultad_seleccionado = facultadService.facultadXID(id);
		Facultad facultad_actualizado = new Facultad();

		facultad_seleccionado.setNombre(facultad.getNombre());

		facultad_actualizado = facultadService.actualizarFacultad(facultad_seleccionado);

		return facultad_actualizado;
	}

	@DeleteMapping("/facultad/{id}")
	public void eliminarFacultad(@PathVariable Integer id) {
		facultadService.eliminarFacultad(id);
	}

}
