package com.dev.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//import com.mysql.cj.Query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
/**
 * Hello world!
 *
 */

public class App{
	
	public static void main(String args[]){
		
		AlienName an=new AlienName();
		an.setFname("Devansh");
		an.setLname("Mehra");
		an.setMname("");
		
		Alien dev=new Alien();
		dev.setAid(100);
		dev.setColor("blue");
		dev.setAname(an);
		
		AlienName an2=new AlienName();
		an2.setFname("Kabir");
		an2.setLname("Puri");
		an2.setMname("");
		
		Alien kabir=new Alien();
		kabir.setAid(101);
		kabir.setColor("red");
		kabir.setAname(an2);
		
		
		Alien a=null;
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session session1=sf.openSession();
		Transaction tx=session1.beginTransaction();
		
		session1.save(dev);
		session1.save(kabir);
		
		tx.commit();
		
		a=(Alien)session1.get(Alien.class, 100);
		System.out.println(a);
		
//		 In Hibernate Query Language(HQL) we specify the name of class instead of table
//		 and attribute name of class instead of column name
//		 Below is the method to get the sql query using Hibernate query
		
//		Query ans=(Query) session1.createQuery("Select color,aid from Alien");
//		List<Object[]>students =(List<Object[]>)ans.list();
//		
//		for(Object[] o : students){
//			System.out.println(o[0]+" "+o[1]);
//		}
		
		// Below is the method to fetch data using SQL commands
		SQLQuery ans=session1.createSQLQuery("Select * from Alien a where a.fname like 'Devansh'");
		ans.addEntity(Alien.class);
		List<Alien> al=ans.list();
		
		for(Alien o : al){
			System.out.println(o);
		}
		session1.close();
		
//		Session session2=sf.openSession();
//		session2.beginTransaction();
		
	}
}





























