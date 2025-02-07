package com.github.percivalgebashe.assignment_4.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter @Setter
@NotBlank
@Component
@ToString
public class TShirtFilterDTO {
    private String id;

    private String name;

    private String colour;

    private Character gender;

    private Character size;

    private Character availability;

    private Double minPrice;

    private Double maxPrice;

    private Double minRating;

    private Double maxRating;
}
