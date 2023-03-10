package realEstateApp;

import Services.PropertyService;
import Services.PropertyServiceImp;
import Utils.ExcelParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import model.Property;
import model.PropertyType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"repository","Services"})
public class Application {

    public static void main(String[] args) throws IOException {
//        ApplicationContext context = SpringApplication.run(Application.class, args);

        File excel = new File("D:\\JavaProjects\\RealEstateSite\\src\\main\\resources\\test.xlsx");
        List<Property> properties = ExcelParser.parseExcel(excel);

        System.out.println(properties);

//        PropertyService service = context.getBean(PropertyServiceImp.class);
//
//        Property property = new Property();
//        property.setExternalID(123342);
//        property.setPrice(150000);
//        property.setType(PropertyType.FLAT);
//        property.setCity("Istanbul");
//        property.setDistrict("Beylikduzu");
//        property.setNeighborhood("Adnan Kahveci");
//
//        service.save(property);
//
//        Property property1 = service.getById(1);
//
//        property1.setType(PropertyType.VILLA);
//
//        service.update(property1);

    }
}
