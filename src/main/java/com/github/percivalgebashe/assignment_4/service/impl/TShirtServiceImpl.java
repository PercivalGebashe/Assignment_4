package com.github.percivalgebashe.assignment_4.service.impl;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.repository.TShirtRepository;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TShirtServiceImpl implements TShirtService {

    private final TShirtRepository tShirtRepository;

    public TShirtServiceImpl(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }

    @Override
    public List<TShirtDTO> getTShirtsByFilters(String colour, Character gender, Character size, Double minPrice, Double maxPrice, Double minRating) {
        List<TShirt> tshirts = tShirtRepository.findAll();

        return tshirts.stream()
                .filter(t -> (colour == null || t.getColour().equalsIgnoreCase(colour)))
                .filter(t -> (gender == null || t.getGender().equals(gender)))
                .filter(t -> (size == null || t.getSize().equals(size)))
                .filter(t -> (minPrice == null || t.getPrice() >= minPrice))
                .filter(t -> (maxPrice == null || t.getPrice() <= maxPrice))
                .filter(t -> (minRating == null || t.getRating() >= minRating))
                .map(TShirtDTO::fromEntity) // Convert to DTO
                .collect(Collectors.toList());
    }
}
