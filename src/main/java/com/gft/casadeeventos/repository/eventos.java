package com.gft.casadeeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.casadeeventos.model.Evento;

public interface eventos extends JpaRepository<Evento, Long>{

}
