package repository;

import jakarta.persistence.criteria.Predicate;
import model.Property;
import org.hibernate.Criteria;

import java.util.List;

public interface PropertyRepository {

    List<Property> findAll();
    Property findById(long id);
    void save(Property property);

    void update(Property property);
    void delete(Property property);

    List<Property> findWithFilter(Predicate criteria);

}
