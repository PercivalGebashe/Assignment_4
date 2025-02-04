package com.github.percivalgebashe.assignment_4.dto;

import com.github.percivalgebashe.assignment_4.entity.TShirt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TShirtDTO {
    private Long id;

    private String name;

    private String colour;

    private Character gender;

    private Character size;

    private Double price;

    private Double rating;

    private Character availability;

    // Factory method to convert Entity to DTO
    public static TShirtDTO fromEntity(TShirt tshirt) {
        return new TShirtDTO(
                tshirt.getId(),
                tshirt.getName(),
                tshirt.getColour(),
                tshirt.getGender(),
                tshirt.getSize(),
                tshirt.getPrice(),
                tshirt.getRating(),
                tshirt.getAvailability()
        );
    }
}
