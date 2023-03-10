package Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.HibernateConfig;
import repository.PropertyRepository;

import java.util.List;

@Component
public class PropertyServiceImp implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;
    @Override
    public Property getById(long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public void save(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void update(Property property) {
        propertyRepository.update(property);
    }

    @Override
    public void delete(Property property) {
        propertyRepository.delete(property);
    }

    @Override
    public List<Property> getWithFilter(Predicate criteria) {
        return propertyRepository.findWithFilter(criteria);
    }
}
