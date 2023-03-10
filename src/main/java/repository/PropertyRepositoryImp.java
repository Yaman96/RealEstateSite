package repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import model.Property;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyRepositoryImp implements PropertyRepository {

    @Autowired
    HibernateConfig hibernate;

    @Override
    public List<Property> findAll() {
        List<Property> properties;
        try (Session session = hibernate.getSessionFactory().openSession()) {
            CriteriaQuery<Property> query = session.getCriteriaBuilder().createQuery(Property.class);
            query.from(Property.class);
            properties = session.createQuery(query).getResultList();
            return properties;
        }
    }

    @Override
    public Property findById(long id) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            return session.get(Property.class,id);
        }
    }

    @Override
    public void save(Property property) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(property);
            transaction.commit();
        }
    }

    @Override
    public void update(Property property) {
        Transaction transaction = null;
        try (Session session = hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(property);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Property> findWithFilter(Predicate criteria) {
        try(Session session = hibernate.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Property> cq = cb.createQuery(Property.class);
            cq.from(Property.class);
            cq.where(criteria);
            TypedQuery<Property> query = session.createQuery(cq);
            return query.getResultList();
        }
    }

    @Override
    public void delete(Property property) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            session.remove(property);
        }
    }
}
