package com.example.midterm;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private Long laptopId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private String price;

    @Column(name = "CPU")
    private String CPU;

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", CPU='" + CPU + '\'' +
                '}';
    }
}
