package com.cmc.hibernate.util;

import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.cmc.persistencia.TObjeto;
import com.cmc.persistencia.TResultado;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory ==null) {
			try {
				Configuration configuration = new Configuration();
			
				//Equivalencia al hibernate.cfg.xml
				Properties settings=new Properties();
				settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				settings.put(Environment.URL, "jdbc:sqlserver://175.26.1.253:1433;databaseName=DevDB");
				settings.put(Environment.USER, "AXPO_WEB_DD");
				settings.put(Environment.PASS, "aXp0_12_@");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");
				
				settings.put(Environment.SHOW_SQL, "true");
				
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				//Se añaden las clases que contienen las anotaciones a mapear
				configuration.addAnnotatedClass(TResultado.class);
				configuration.addAnnotatedClass(TObjeto.class);
				configuration.setProperties(settings);
				
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySetting(AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "jdbc" )
						.applySettings(configuration.getProperties())
						.build();
				 
				sessionFactory =configuration.buildSessionFactory(serviceRegistry);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return sessionFactory;
	}
}