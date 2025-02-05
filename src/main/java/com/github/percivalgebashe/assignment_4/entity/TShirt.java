package com.github.percivalgebashe.assignment_4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tshirts")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TShirt {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "colour", nullable = false)
    private String colour;

    @Column(name = "gender", nullable = false)
    private Character gender;

    @Column(name = "size", nullable = false)
    private Character size;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "availability", nullable = false)
    private Character availability;
}
