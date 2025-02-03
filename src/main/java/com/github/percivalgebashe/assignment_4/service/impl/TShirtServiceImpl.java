package com.github.percivalgebashe.assignment_4.service.impl;

import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.repository.TShirtRepository;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TShirtServiceImpl implements TShirtService {

    private final TShirtRepository tShirtRepository;

    public TShirtServiceImpl(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return tShirtRepository.findAll();
    }

    @Override
    public Optional<TShirt> getTShirtById(Long id) {
        return tShirtRepository.findById(id);
    }

    @Override
    public TShirt createTShirt(TShirt tShirt) {
        return tShirtRepository.save(tShirt);
    }

    @Override
    public TShirt updateTShirt(Long id, TShirt tShirt) {
        return tShirtRepository.findById(id).map(existing -> {
            existing.setName(tShirt.getName());
            existing.setColour(tShirt.getColour());
            existing.setGender(tShirt.getGender());
            existing.setSize(tShirt.getSize());
            existing.setPrice(tShirt.getPrice());
            existing.setRating(tShirt.getRating());
            existing.setAvailability(tShirt.getAvailability());
            return tShirtRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("TShirt not found with id " + id));
    }

    @Override
    public void deleteTShirtById(Long id) {
        tShirtRepository.deleteById(id);
    }

    @Override
    public void deleteTShirtsById(List<Long> ids) {
        ids.forEach(tShirtRepository::deleteById);
    }

    @Override
    public List<TShirt> findByColour(String colour) {
        return tShirtRepository.findByColour(colour);
    }

    @Override
    public List<TShirt> findBySize(char size) {
        return tShirtRepository.findBySize(size);
    }

    @Override
    public List<TShirt> findByGender(char gender) {
        return tShirtRepository.findByGender(gender);
    }

    @Override
    public List<TShirt> findByColourSizeGender(String colour, char size, char gender) {
        return tShirtRepository.findByColourAndSizeAndGender(colour, size, gender);
    }
}
