package com.cmc.hibernate.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cmc.hibernate.repositorio.TResultadoRepositorio;
import com.cmc.persistencia.TResultado;

@Repository
public class TResultadoDAO {
	private static final Logger log = LoggerFactory.getLogger(TResultadoDAO.class);

	@Autowired
	private TResultadoRepositorio tResultado_repo;

	@Transactional
	public boolean cargarResultados(List<TResultado> resultados) {
		if ( tResultado_repo.saveAll(resultados).equals(resultados)) {
			return true;
		}else {
			return false;
		}
			
	}
	

}
