package controller;

import model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PropertyController {

//    @Autowired
//    private PropertyService propertyService;

    @GetMapping("/properties")
    public String listProperties(Model model) {
        List<Property> properties = new ArrayList<>(); //get all properties from property service. propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        return "temp properties/list";
    }

    @GetMapping("/properties/{id}")
    public String getPropertyDetails(@PathVariable("id") Long id, Model model) {
        Property property = new Property(); // propertyService.getById();
        model.addAttribute("property",property);
        return "temp properties/property-details";
    }

    @PostMapping("/properties")
    public String addProperty(@ModelAttribute("property") Property property) {
        //propertiesRepository.addProperty(property);
        return "temp redirect:/properties/list";
    }

    @PutMapping("/properties/{id}")
    public String updateProperty(@PathVariable("id") long id, @Valid Property updatedProperty, BindingResult result, Model model) {
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
        return "redirect:/properties/"; // + existingProperty.getId();
    }

    @GetMapping("/properties/search")
    public String searchProperties(@RequestParam String location, int bedrooms, int anotherParam, Model model) {
//        List<Property> searchResult = propertyService.findProperty(location,bedrooms,anotherParam);
//        model.addAttribute("properties", properties);
        return "temp properties/list";
    }

    @PostMapping("/properties/delete/{id}")
    public String deleteProperty(@PathVariable("id") long id, Model model) {
        // Найти объект по id
//        Property property = propertyRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid property id: " + id));
//
//        // Удалить объект из репозитория
//        propertyRepository.delete(property);
//
//        // Обновить модель и перенаправить на страницу со списком объектов недвижимости
//        model.addAttribute("properties", propertyRepository.findAll());
        return "redirect:/properties";
    }

}
