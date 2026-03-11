package com.EmployeeManagementSystem.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			System.out.println("Setting Up SessionFactory...");
			
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

			sessionFactory = metaData.getSessionFactoryBuilder().build();
			
			System.out.println("SessionFactory setup successful...");
		}
		
		return sessionFactory;
	}

	public static void shutdown() {
		System.out.println("Closing SessionFactory...");
		
		if (standardServiceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			
			System.out.println("Session Factory closed...");
		}
	}
}