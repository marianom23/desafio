package com.assertiva.desafio.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="mensajes")
public class Mensaje implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
    @NotNull(message = "El mensaje no puede estar vacio")
    @Size(min = 1, max = 10000, message = "El nombre debe tener entre 1 y 10000 caracteres")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "El mensaje debe contener solo letras")
    private String mensaje;
	
    @NotNull(message = "Los digitos no pueden ser nulos")
    @Pattern(regexp = "^[0-9 ]+$", message = "Los dígitos deben contener solo números")
    @Size(min =  1, max = 9, message = "El número debe tener un máximo de 9 dígitos")
	private String digitos;

    
	public String getDigitos() {
		return digitos;
	}

	public void setDigitos(String digitos) {
		this.digitos = digitos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	private static final long serialVersionUID = 1L;
}
