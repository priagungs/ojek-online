package com.future.ojekonline.entity;

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

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

}
