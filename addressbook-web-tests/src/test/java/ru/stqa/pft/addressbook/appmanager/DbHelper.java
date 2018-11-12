package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import java.security.acl.Group;
import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper()  {

    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {

       // System.out.println("wejscie do groups");
        Session session = sessionFactory.openSession();
       // System.out.println("pobranie do groups");
        session.beginTransaction();
       // System.out.println("look groups");
        List<GroupData> result = session.createQuery("from GrouptData").list();
      //  System.out.println("duck do groups");
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Kontakts kontakts() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List <KontaktData> result = session.createQuery("from KontaktData").list();
        session.getTransaction().commit();
        session.close();
        return new Kontakts(result);
    }
}


