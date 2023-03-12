package realEstateApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import realEstateApp.Services.PropertyService;
import realEstateApp.model.Property;

import java.util.List;

@RestController
public class PropertyRESTController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    @ResponseBody
    public List<Property> listProperties(@RequestParam(required = false) String type,
                                         @RequestParam(required = false) String maxPrice,
                                         @RequestParam(required = false) String minPrice,
                                         @RequestParam(required = false) String rooms,
                                         @RequestParam(required = false) String district,
                                         @RequestParam(required = false) String neighborhood) {
        return propertyService.getWithFilter(type, maxPrice, minPrice, rooms, district, neighborhood);
    }
}
