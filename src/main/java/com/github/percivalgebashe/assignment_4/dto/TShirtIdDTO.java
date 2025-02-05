package com.github.percivalgebashe.assignment_4.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NotBlank
@Min(1)
@Component
@ToString
public class TShirtIdDTO {
    private String id;
}
