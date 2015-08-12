/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cosw.flights.test;

import edu.eci.cosw.flights.persistence.model.Aeronave;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class PersistenceTest {
    

    private SessionFactory sessionFactory;
    private Session session = null;
    
    /**
     * Operaciones que se realizan antes de ejecutar el banco de pruebas.
     * En este caso se crea una misma sesión que será usada en todas las
     * pruebas.
     */
    @Before
    public void setupSession() {
        
        Configuration configuration = new Configuration();
        //configuration.configure("hibernate.cfg.xml");
        /**
         * PARA LAS PRUEBAS SE USA UNA BASE DE DATOS H2 EN MEMORIA
         */
        configuration.configure("hibernate-inmemory.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        
    }
        
    /**
     * Operaciones que se realizan cuando finalice la ejecución de las pruebas.
     * En este caso se cierra la sesi_n y la f_brica de sesiones.
     */
    @After
    public void closeResources(){
        session.close();
        sessionFactory.close();
    }
    
    
     /**
     * EJEMPLO DE PRUEBA
     * Objetivo: Probar que el mapeo permita hacer persistentes
     * aeronaves, y luego realizar cálculos consistentes con las
     * mismas.
     * Estado inicial: base de datos vacía.
     * Prueba: La consulta de la sumatora de la capacidad de las aeronaves
     * debe ser consistente con los capacidades ingresadas inicialmente.
     * 
     */
    @Test
    public void aeronavePersistenceTest(){
        Transaction tx=session.beginTransaction();
        Aeronave an=new Aeronave(1111, 1960, "AK99", 100);
        session.save(an);
        Aeronave an2=new Aeronave(2222, 1970, "AK99", 110);
        session.save(an2);
               
        Query q=session.createQuery("select sum(an.capacidad) from Aeronave an");
        List<Long> res=q.list();
        
        Assert.assertEquals("La prueba de consultar"
                + " la capacidad total de las aeronaves"
                + " no da un resultado consistente", res.get(0),new Long(210));                
        
        tx.commit();        
    }

    
    
}
