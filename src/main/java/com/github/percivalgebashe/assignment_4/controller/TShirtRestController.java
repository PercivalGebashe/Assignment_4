package com.github.percivalgebashe.assignment_4.controller;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tshirts")
public class TShirtRestController {

    private final TShirtService tShirtService;

    public TShirtRestController(TShirtService tShirtService) {
        this.tShirtService = tShirtService;
    }

    @GetMapping
    public ResponseEntity<List<TShirtDTO>> getTShirts(
            @RequestParam(required = false) String colour,
            @RequestParam(required = false) Character gender,
            @RequestParam(required = false) Character size,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minRating
    ) {
        List<TShirtDTO> tshirts = tShirtService.getTShirtsByFilters(colour, gender, size, minPrice, maxPrice, minRating);
        return new ResponseEntity<>(tshirts, HttpStatus.OK);
    }
}
