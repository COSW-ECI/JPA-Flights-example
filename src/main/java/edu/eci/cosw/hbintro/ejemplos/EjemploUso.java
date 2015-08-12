/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.hbintro.ejemplos;

import edu.eci.cosw.flightsex.persistence.model.Vuelo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author hcadavid
 */
public class EjemploUso {
    
    public static void main(String a[]){
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate3.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        
        Session session=sessionFactory.openSession();        
        Transaction tx=session.beginTransaction();

        Query q=session.createQuery("select distinc p from Vuelo as v inner join v.pasajeros as p");
        
        
        
        System.out.println(q.list());
        
        //TRANSACCION CON HIBERNATE
        
        tx.commit();
        session.close();
        
        
    }
    
}
