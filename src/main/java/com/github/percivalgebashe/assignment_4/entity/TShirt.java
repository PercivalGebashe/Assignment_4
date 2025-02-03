package com.github.percivalgebashe.assignment_4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tshirts")
@ToString
@NoArgsConstructor  // Lombok to generate a no-arg constructor
public class TShirt {

    @Id
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Long id;

    @Column(name = "name", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "colour", nullable = false)
    @Getter @Setter
    private String colour;

    @Column(name = "gender", nullable = false)
    @Getter @Setter
    private char gender;

    @Column(name = "size", nullable = false)
    @Getter @Setter
    private char size;

    @Column(name = "price", nullable = false)
    @Getter @Setter
    private double price;

    @Column(name = "rating", nullable = false)
    @Getter @Setter
    private double rating;

    @Column(name = "availability", nullable = false)
    @Getter @Setter
    private char availability;

    // Custom constructor for easier instantiation
    public TShirt(Long id, String name, String colour, char gender, char size, double price, double rating, char availability) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.gender = gender;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }
}
