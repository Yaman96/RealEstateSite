package realEstateApp.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import realEstateApp.model.Property;

import java.util.List;

public interface PropertyRepository {

    List<Property> findAll();
    Property findById(long id);
    void save(Property property);

    void update(Property property);
    void delete(Property property);

    List<Property> findWithFilter(String type, String maxPrice, String minPrice, String city, String district, String neighborhood);

}
