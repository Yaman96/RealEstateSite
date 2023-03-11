package realEstateApp.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@Entity
@Table(name = "properties")
@Getter@Setter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "external_id", unique = true)
    @NotNull
    private long externalID;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PropertyType type;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "district")
    @NotNull
    private String district;

    @Column(name = "neighborhood")
    @NotNull
    private String neighborhood;

    @ElementCollection
    @Column(name = "photos")
    private List<String> photos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return new EqualsBuilder().append(externalID, property.externalID).append(price, property.price).append(type, property.type).append(city, property.city).append(district, property.district).append(neighborhood, property.neighborhood).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(externalID).append(type).append(price).append(city).append(district).append(neighborhood).toHashCode();
    }

//    @Column(name = "bedrooms")
//    @NotNull
//    private int bedrooms;
//
//    @Column(name = "bathrooms")
//    @NotNull
//    private int bathrooms;
//
//    @Column(name = "salon")
//    @NotNull
//    private int salon;
//
//    @Column(name = "area_gross")
//    @NotNull
//    private int areaGross;
//
//    @Column(name = "area_net")
//    @NotNull
//    private int areaNet;
//
//    @Column(name = "floor")
//    @NotNull
//    private int floor;
//
//    @Column(name = "american_kitchen")
//    @NotNull
//    private boolean hasAmericanKitchen;
//
//    @Column(name = "master_room")
//    @NotNull
//    private boolean hasMasterRoom;
//@Column(name = "address")
//@NotNull
//private String address;
//@Column(name = "contact_name")
//@NotNull
//private String contactName;
//
//    @Column(name = "contact_phone")
//    @NotNull
//    private String contactPhone;
//
//    @Column(name = "contact_email")
//    @NotNull
//    private String contactEmail;

    //    @Column(name = "posting_date")
//    @NotNull
//    private LocalDate postingDate;

    //    @Column(name = "location")
//    @NotNull
//    private String location;

    //    @Column(name = "description")
//    @NotNull
//    private String description;
}
