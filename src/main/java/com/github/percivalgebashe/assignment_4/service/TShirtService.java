package com.github.percivalgebashe.assignment_4.service;

import com.github.percivalgebashe.assignment_4.entity.TShirt;

import java.util.List;
import java.util.Optional;

public interface TShirtService {

    List<TShirt> getAllTShirts();
    Optional<TShirt> getTShirtById(Long id);
    TShirt createTShirt(TShirt tShirt);
    TShirt updateTShirt(Long id, TShirt tShirt);

    void deleteTShirtById(Long id);
    void deleteTShirtsById(List<Long> ids);

    List<TShirt> findByColour(String colour);
    List<TShirt> findBySize(char size);
    List<TShirt> findByGender(char gender);
    List<TShirt> findByColourSizeGender(String colour, char size, char gender);
}
