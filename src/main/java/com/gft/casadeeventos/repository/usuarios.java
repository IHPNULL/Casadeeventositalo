package com.gft.casadeeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.casadeeventos.model.Usuario;

public interface usuarios extends  JpaRepository<Usuario, Long>{
	
}
