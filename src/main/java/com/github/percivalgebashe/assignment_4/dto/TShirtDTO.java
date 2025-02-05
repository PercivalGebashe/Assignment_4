package com.github.percivalgebashe.assignment_4.dto;

import com.github.percivalgebashe.assignment_4.entity.TShirt;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
public class TShirtDTO {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String colour;

    @NotBlank
    @Pattern(regexp = "[AZ]+")
    private Character gender;

    @NotBlank
    @Pattern(regexp = "[SML]+")
    private Character size;

    @NotBlank
    @Min(0)
    private Double price;

    @NotBlank
    @Min(0)
    @Max(5)
    private Double rating;

    @NotBlank
    @Pattern(regexp = "[YN]")
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
