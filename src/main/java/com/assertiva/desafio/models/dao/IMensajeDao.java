package com.assertiva.desafio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.assertiva.desafio.models.entity.Mensaje;

public interface IMensajeDao extends CrudRepository<Mensaje, Integer> {

}
