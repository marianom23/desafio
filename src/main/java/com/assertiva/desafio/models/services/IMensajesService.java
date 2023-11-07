package com.assertiva.desafio.models.services;

import java.util.List;

import com.assertiva.desafio.models.entity.Mensaje;

public interface IMensajesService {
	
	public List<Mensaje> findAll();
	public void save(Mensaje mensaje);
	public Mensaje findById(Integer id);
	public void delete(Mensaje mensaje);

}
