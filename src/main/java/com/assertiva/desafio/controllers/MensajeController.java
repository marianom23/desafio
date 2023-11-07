package com.assertiva.desafio.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assertiva.desafio.models.entity.Mensaje;
import com.assertiva.desafio.models.services.IMensajesService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = { "http://localhost:8080" })
@RequestMapping("/api")
public class MensajeController {

	@Autowired
	private IMensajesService mensajeService;

	@PostMapping("/encriptar")
	public Mensaje guardarMensaje(@Valid @RequestBody Mensaje mensaje) {

		String texto = mensaje.getMensaje();
		String clave = mensaje.getDigitos();
		
		//clave = texto.replaceAll("\\s+", "");
		texto = texto.replaceAll("\\s+", "");
		texto = texto.toUpperCase();

		int cantidadDigitos = clave.length();

		StringBuilder codificado = new StringBuilder();

		int indiceClave = 0;

		for (char letra : texto.toCharArray()) {

			int Numero = Character.getNumericValue(clave.charAt(indiceClave));

			letra = (char) ('A' + (letra - 'A' + Numero) % 26);

			codificado.append(letra);

			indiceClave = (indiceClave + 1) % cantidadDigitos;
		}

		mensaje.setMensaje(codificado.toString());

		this.mensajeService.save(mensaje);

		return mensaje;
	}
	
	@GetMapping("/ver-encriptaciones")
	public List<Mensaje> verEncriptaciones() {
		return mensajeService.findAll();
	}
	
	@DeleteMapping("/borrar-encriptacion/{id}")
	public ResponseEntity<String> borrarEncriptacion(@PathVariable int id) {
	    try {
	        Mensaje mensaje = this.mensajeService.findById(id);
	        this.mensajeService.delete(mensaje);
	        return ResponseEntity.ok("Mensaje con ID " + id + " eliminado correctamente");
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un mensaje con ID " + id);
	    }
	}


	

}



