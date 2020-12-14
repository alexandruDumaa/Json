package com.cmc.hibernate.dao;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cmc.hibernate.dao.TObjetoDAO;
import com.cmc.hibernate.util.HibernateUtil;
import com.cmc.persistencia.TObjeto;


@Repository
public class TObjetoDAO {

	private static final Logger log = LoggerFactory.getLogger(TObjetoDAO.class);

	
	// ***** DECLARACIÓN DE MÉTODOS PROPIOS******

	
	public List<TObjeto> buscarIp(String ip) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {	
			log.info("Se va a proceder a buscar por la ip indicada en el cuerpo de la consulta");
			session.getTransaction().begin();
			String hql = ("FROM TObjeto to WHERE to.ip=:ip");
			
			Query<TObjeto> query = session.createQuery(hql, TObjeto.class);
			query.setParameter("ip", ip);
			
			List<TObjeto> results = (List<TObjeto>) query.list();
			session.getTransaction().commit();
			return results;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}	
}
