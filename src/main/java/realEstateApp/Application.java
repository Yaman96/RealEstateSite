package realEstateApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import realEstateApp.Services.PropertyService;
import realEstateApp.Utils.ExcelParser;
import realEstateApp.model.Property;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        PropertyService propertyService = context.getBean(PropertyService.class);

        File file = new File("C:\\Users\\yaman\\IdeaProjects\\RealEstateSite\\src\\main\\resources\\test.xlsx");
        propertyService.addNewProperties(file);


    }
}
