package com.github.percivalgebashe.assignment_4.service;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;

import java.util.List;

public interface TShirtService {
    List<TShirtDTO> getTShirtsByFilters(String colour,
                                        Character gender,
                                        Character size,
                                        Double minPrice,
                                        Double maxPrice,
                                        Double minRating);
}
