package realEstateApp;

import repository.HibernateConfig;
import model.Property;
import model.PropertyType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        HibernateConfig hibernateConfig = new HibernateConfig();

        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Property property = new Property();
        property.setExternalID(123342);
        property.setPrice(150000);
        property.setType(PropertyType.FLAT);
        property.setCity("Istanbul");
        property.setDistrict("Beylikduzu");
        property.setNeighborhood("Adnan Kahveci");

        session.persist(property);

        transaction.commit();

        session.close();
    }
}
