package realEstateApp.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import realEstateApp.model.Property;

import java.io.File;
import java.util.List;

public interface PropertyService {

    Property getById(long id);
    List<Property> getAll();
    void update(Property property);
    void delete(Property property);
    void save(Property property);
    List<Property> getWithFilter(String type, String maxPrice, String minPrice, String rooms, String district, String neighborhood);
    void addNewProperties(File file);
}
