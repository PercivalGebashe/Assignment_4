package com.github.percivalgebashe.assignment_4.service.impl;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtFilterDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtIdDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.repository.TShirtRepository;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TShirtServiceImpl implements TShirtService {

    private final TShirtRepository tShirtRepository;

    @Autowired
    public TShirtServiceImpl(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }

    @Override
    public List<TShirtDTO> getTShirtsByFilters(TShirtFilterDTO filterDTO) {
        return tShirtRepository.findAll().stream()
                .filter(t -> filterDTO.getName() != null && t.getName().equalsIgnoreCase(filterDTO.getName()))
                .filter(t -> filterDTO.getColour() != null && t.getColour().equalsIgnoreCase(filterDTO.getColour()))
                .filter(t -> filterDTO.getGender() != null && t.getGender() == filterDTO.getGender())
                .filter(t -> filterDTO.getSize() != null && t.getSize() == filterDTO.getSize())
                .filter(t -> filterDTO.getMinPrice() != null && t.getPrice() >= filterDTO.getMinPrice())
                .filter(t -> filterDTO.getMaxPrice() != null && t.getPrice() <= filterDTO.getMaxPrice())
                .filter(t -> filterDTO.getMinRating() != null && t.getRating() >= filterDTO.getMinRating())
                .filter(t -> filterDTO.getMaxRating() != null && t.getRating() <= filterDTO.getMaxRating())
                .filter(t -> filterDTO.getAvailability() != null && t.getAvailability() == filterDTO.getAvailability())
                .map(TShirtDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TShirtDTO> getTShirts() {
        return tShirtRepository.findAll().stream()
                .map(TShirtDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public TShirt findById(String id) {
        return tShirtRepository.findById(id).orElse(null);
    }
}
