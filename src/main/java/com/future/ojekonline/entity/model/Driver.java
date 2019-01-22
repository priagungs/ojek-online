package com.future.ojekonline.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String license;

    @OneToMany(mappedBy = "driver")
    @JsonIgnoreProperties({"driver"})
    private List<Booking> bookings;

    private Boolean availability = true;

    private Long balance;

}
