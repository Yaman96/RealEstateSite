package repository;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import model.Property;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepositoryImp implements PropertyRepository {

    @Autowired
    HibernateConfig hibernate;

    @Override
    public List<Property> findAll() {
        List<Property> properties = new ArrayList<>();
        try (Session session = hibernate.getSessionFactory().openSession()) {
            CriteriaQuery<Property> query = session.getCriteriaBuilder().createQuery(Property.class);
            query.from(Property.class);
            return session.createQuery(query).getResultList();
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
            session.persist(property);
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
            CriteriaQuery<Property> query = session.getCriteriaBuilder().createQuery(Property.class);
            Root<Property> root = query.from(Property.class);
            query.select(root);
            query.where(criteria);
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public void delete(Property property) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            session.remove(property);
        }
    }
}
