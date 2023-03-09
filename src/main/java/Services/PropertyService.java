package Services;

import jakarta.persistence.criteria.Predicate;
import model.Property;
import org.hibernate.Criteria;

import java.util.List;

public interface PropertyService {

    Property getById(long id);
    List<Property> getAll();
    void update(Property property);
    void delete(Property property);
    List<Property> getWithFilter(Predicate criteria);
}
