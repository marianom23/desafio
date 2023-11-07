package com.assertiva.desafio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assertiva.desafio.models.dao.IMensajeDao;
import com.assertiva.desafio.models.entity.Mensaje;

import jakarta.transaction.Transactional;

@Service
public class MensajeServiceImpl implements IMensajesService {
	
	@Autowired
	private IMensajeDao mensajeDao;
	
	@Override
	@Transactional
	public List<Mensaje> findAll() {
		return (List<Mensaje>) mensajeDao.findAll();
	}

	@Override
	@Transactional
	public void save(Mensaje mensaje) {
		mensajeDao.save(mensaje);
	}

	@Override
	@Transactional
	public Mensaje findById(Integer id) {
		return mensajeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Mensaje mensaje) {
		mensajeDao.delete(mensaje);
	}

}
