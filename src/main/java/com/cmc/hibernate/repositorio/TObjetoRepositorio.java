package com.cmc.hibernate.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.persistencia.TObjeto;

@Repository
public interface TObjetoRepositorio extends JpaRepository <TObjeto, String>{
	
	
	
}
