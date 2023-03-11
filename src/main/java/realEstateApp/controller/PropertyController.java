package realEstateApp.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.ui.Model;
import realEstateApp.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import realEstateApp.model.Property;
import realEstateApp.model.PropertyType;
import realEstateApp.repository.HibernateConfig;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/home")
    public String homaPage() {
        return "home";
    }

    @GetMapping("/properties")
    public String listProperties(@RequestParam(required = false) String type,
                                 @RequestParam(required = false) String maxPrice,
                                 @RequestParam(required = false) String minPrice,
                                 @RequestParam(required = false) String city,
                                 @RequestParam(required = false) String district,
                                 @RequestParam(required = false) String neighborhood,
                                 Model model) {
        List<Property> properties = propertyService.getWithFilter(type, maxPrice, minPrice, city, district, neighborhood);
        model.addAttribute("properties", properties);
        return "list";
    }
//
//    @GetMapping("/properties/{id}")
//    public String getPropertyDetails(@PathVariable("id") Long id, Model model) {
//        Property property = new Property(); // propertyService.getById();
//        model.addAttribute("property",property);
//        return "temp properties/property-details";
//    }
//
//    @PutMapping("/properties/{id}")
//    public String updateProperty(@PathVariable("id") long id, @Valid Property updatedProperty, BindingResult result, Model model) {
        // Проверяем наличие ошибок валидации
//        if (result.hasErrors()) {
//            updatedProperty.setId(id); // Устанавливаем id объекта недвижимости
//            return "edit-property"; // Возвращаем представление для редактирования объекта недвижимости
//        }
//
//        // Получаем объект недвижимости по его id
//        Property existingProperty = propertyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid property id: " + id));
//
//        // Обновляем информацию о существующем объекте недвижимости
//        existingProperty.setLocation(updatedProperty.getLocation());
//        existingProperty.setPrice(updatedProperty.getPrice());
//        existingProperty.setRooms(updatedProperty.getRooms());
//        existingProperty.setArea(updatedProperty.getArea());
//
//        // Сохраняем обновленную информацию об объекте недвижимости
//        propertyRepository.save(existingProperty);
//
//        // Перенаправляем на страницу просмотра объекта недвижимости
//        return "redirect:/properties/"; // + existingProperty.getId();
//    }

//    @GetMapping("/properties/search")
//    public String searchProperties(@RequestParam String location, int bedrooms, int anotherParam, Model model) {
////        List<Property> searchResult = propertyService.findProperty(location,bedrooms,anotherParam);
////        model.addAttribute("properties", properties);
//        return "temp properties/list";
//    }
//
//    @PostMapping("/properties/delete/{id}")
//    public String deleteProperty(@PathVariable("id") long id, Model model) {
//        // Найти объект по id
////        Property property = propertyRepository.findById(id)
////                .orElseThrow(() -> new IllegalArgumentException("Invalid property id: " + id));
////
////        // Удалить объект из репозитория
////        propertyRepository.delete(property);
////
////        // Обновить модель и перенаправить на страницу со списком объектов недвижимости
////        model.addAttribute("properties", propertyRepository.findAll());
//        return "redirect:/properties";
//    }
}
