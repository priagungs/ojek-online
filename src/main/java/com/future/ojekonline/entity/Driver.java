package com.future.ojekonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private String license;

    @OneToMany(mappedBy = "driver")
    @JsonIgnoreProperties({"driver"})
    private List<Booking> bookings;

    private Boolean availability = true;

    private Long balance;

}
