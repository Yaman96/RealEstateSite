package model;

import lombok.Getter;
import lombok.Setter;

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

    private int price;

    private PropertyType type;

    private int bedrooms;

    private int bathrooms;

    private int salon;

    private int area;

    private String description;

    private List<String> photos;

    private String contactName;

    private String contactPhone;

    private String contactEmail;

    private LocalDate postingDate;

    private String location;

    private String address;
}
