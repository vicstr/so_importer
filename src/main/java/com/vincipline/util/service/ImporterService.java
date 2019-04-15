package com.vincipline.util.service;

import com.vincipline.util.entity.Badge;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImporterService {

    protected Badge          badge             = null;
    protected Session        sessionObj        = null;
    protected SessionFactory sessionFactoryObj = null;

    private SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(Badge.class);

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties())
                .build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public void run() {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            //for (int i = 5101; i <= 5105; i++) {
            badge = new Badge()
                    .setId(1)
                    .setUserId(2)
                    .setName("Autobiographer")
                    .setDate(this.parseDateTime("2010-09-01T18:25:23.487"))
                    .setClassification((short) 3)
                    .setTagBased(Boolean.FALSE);

            sessionObj.save(badge);
            //}
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    protected Date parseDateTime(String time) {
        Date parsedDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            parsedDate = sdf.parse(time);
        } catch (ParseException e) {
            //do nothing
        }
        return parsedDate;
    }
}
