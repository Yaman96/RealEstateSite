package realEstateApp.repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import realEstateApp.model.Property;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import realEstateApp.model.PropertyType;

import java.util.ArrayList;
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
    public List<Property> findWithFilter(String type, String maxPrice, String minPrice, String city, String district, String neighborhood) {
        try(Session session = hibernate.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Property> query = builder.createQuery(Property.class);
            Root<Property> root = query.from(Property.class);
            List<Predicate> predicates = new ArrayList<>();
            if (type != null && !type.isEmpty()) {
                predicates.add(builder.equal(root.get("type"), PropertyType.valueOf(type.toUpperCase())));
            }
            if (maxPrice != null && !maxPrice.isEmpty()) {
                int max = Integer.parseInt(maxPrice);
                predicates.add(builder.le(root.get("price"), max));
            }
            if (minPrice != null && !minPrice.isEmpty()) {
                int min = Integer.parseInt(minPrice);
                predicates.add(builder.ge(root.get("price"), min));
            }
            if (city != null && !city.isEmpty()) {
                predicates.add(builder.equal(root.get("city"), city));
            }
            if (district != null && !district.isEmpty()) {
                predicates.add(builder.equal(root.get("district"), district));
            }
            if (neighborhood != null && !neighborhood.isEmpty()) {
                predicates.add(builder.equal(root.get("neighborhood"), neighborhood));
            }
            query.select(root).where(predicates.toArray(new Predicate[0]));

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
