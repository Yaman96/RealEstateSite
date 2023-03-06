package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "properties")
@Getter@Setter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private int price;

    @NonNull
    private PropertyType type;

    @NonNull
    private int bedrooms;

    @NonNull
    private int bathrooms;

    @NonNull
    private int salon;

    @NonNull
    private int area;

    @NonNull
    private int floor;

    @NonNull
    private String description;

    @NonNull
    private List<String> photos;

    @NonNull
    private String contactName;

    @NonNull
    private String contactPhone;

    private String contactEmail;

    private LocalDate postingDate;

    private String location;

    private String address;
}
