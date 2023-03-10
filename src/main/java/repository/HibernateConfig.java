package repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateConfig {
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateConfig() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
