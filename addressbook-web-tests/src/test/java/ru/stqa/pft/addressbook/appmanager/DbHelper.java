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


        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData where deprecated = '0000-00-00'").list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Kontakts kontakts() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List <KontaktData> result = session.createQuery("from KontaktData where deprecated = '0000-00-00'").list();
        session.getTransaction().commit();
        session.close();
        return new Kontakts(result);
    }
}


