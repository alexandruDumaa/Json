package com.cmc.hibernate.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cmc.hibernate.dao.TObjetoDAO;
import com.cmc.hibernate.dao.TResultadoDAO;
import com.cmc.hibernate.util.HibernateUtil;
import com.cmc.persistencia.TObjeto;
import com.cmc.persistencia.TResultado;
import com.cmc.objetos.Dato;
import com.cmc.objetos.ObjOrigen;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @version 1.0.
 * @since 10/12/2020.
 *
 */

@Component
@Service
public class Gestion_DAO implements IGestion_DAO {

	private static final Logger log = LoggerFactory.getLogger(Gestion_DAO.class);

	public static Logger getLog() {
		return log;
	}

	@Autowired
	private TObjetoDAO tObjeto_dao;

	@Autowired
	private TResultadoDAO tResultado_dao;

	// *************** CONSULTAS ***************

	@Override	
	public boolean cargarHistorico(ObjOrigen objeto) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<TObjeto> tagNames = tObjeto_dao.buscarIp(objeto.getIp());

			TResultado resultado = new TResultado();
			List<TResultado> resultados = new ArrayList<TResultado>();
			
			for (Dato o : objeto.getDatos()) {
				resultado.setFecha(Timestamp.valueOf(objeto.getFecha()));
				resultado.setValor(Float.parseFloat(o.getValor()));
				resultado.setTagName(tagNames.stream().filter(x -> o.getId().equals(x.getId())).map(TObjeto::getTagName)
						.findAny().orElse(""));
				resultados.add(resultado);
				resultado=new TResultado();
			}
			log.info("RESULTADOS:"+resultados.toString());
			tResultado_dao.cargarResultados(resultados);
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			return false;
		}
	}

}
