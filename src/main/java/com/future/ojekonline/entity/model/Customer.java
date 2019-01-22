package com.future.ojekonline.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private Long balance;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties({"customer"})
    private List<Booking> bookings;

}
