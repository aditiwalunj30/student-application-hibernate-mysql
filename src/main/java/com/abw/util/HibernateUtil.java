package com.abw.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.abw.config.HibernateConfig;


public class HibernateUtil {

	private static SessionFactory sf = null;

	private HibernateUtil() {}

	public static  SessionFactory getSessionFactory() {

		if (sf== null)
		{
			Configuration configuration = new Configuration();
			configuration.configure(HibernateConfig.FILE_NAME);
			sf= configuration.buildSessionFactory();
		}
		return sf;
	}

	public static void closeSessionFactory()
	{
		if(sf != null)
		{
			sf.close();
		}

	}

}
