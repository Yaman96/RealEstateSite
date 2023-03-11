package realEstateApp.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import realEstateApp.Utils.ExcelParser;
import jakarta.persistence.criteria.Predicate;
import realEstateApp.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import realEstateApp.repository.PropertyRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
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
    public List<Property> getWithFilter(String type, String maxPrice, String minPrice, String city, String district, String neighborhood) {
        return propertyRepository.findWithFilter(type, maxPrice, minPrice, city, district, neighborhood);
    }

    @Override
    public void addNewProperties(File file) {
            List<Property> propertiesFromFile = ExcelParser.parseExcel(file);
            List<Property> propertiesFromDB = propertyRepository.findAll();

            List<Property> uniqPropertySet = new ArrayList<>(propertiesFromFile);
            boolean isDB_Changed = uniqPropertySet.removeAll(propertiesFromDB);

            for (Property property : uniqPropertySet) {
                propertyRepository.save(property);
            }

            if (isDB_Changed)
                System.out.println("Database has been changed.");
            else
                System.out.println("No changes in database.");
    }
}
