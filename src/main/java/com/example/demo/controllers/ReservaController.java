package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Reserva;
import com.example.demo.services.ReservaService;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	@GetMapping("/reservas")
	public List<Reserva> listarReservas() {
		return reservaService.listarReservas();
	}

	@GetMapping("/reserva/{id}")
	public Reserva reservaXID(@PathVariable(name = "id") Integer id) {
		return reservaService.reservaXID(id);
	}

	@PostMapping("/reserva")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaService.guardarReserva(reserva);
	}

	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") Integer id, @RequestBody Reserva reserva) {

		Reserva reserva_seleccionado = reservaService.reservaXID(id);
		Reserva reserva_actualizado = new Reserva();

		reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());

		reserva_actualizado = reservaService.actualizarReserva(reserva_seleccionado);

		return reserva_actualizado;
	}

	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable Integer id) {
		reservaService.eliminarReserva(id);
	}

}
