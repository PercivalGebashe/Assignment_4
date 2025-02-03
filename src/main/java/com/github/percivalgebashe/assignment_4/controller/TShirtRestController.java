package com.github.percivalgebashe.assignment_4.controller;

import com.github.percivalgebashe.assignment_4.dto.TShirtIds;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tshirts")
public class TShirtRestController {

    private final TShirtService tShirtService;

    public TShirtRestController(TShirtService tShirtService) {
        this.tShirtService = tShirtService;
    }

    // GET all TShirts
    @GetMapping
    public ResponseEntity<List<TShirt>> getAllTShirts() {
        List<TShirt> tshirts = tShirtService.getAllTShirts();
        return new ResponseEntity<>(tshirts, HttpStatus.OK);
    }

    // GET a TShirt by id
    @GetMapping("/{id}")
    public ResponseEntity<TShirt> getTShirtById(@PathVariable Long id) {
        return tShirtService.getTShirtById(id)
                .map(tShirt -> new ResponseEntity<>(tShirt, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST a new TShirt
    @PostMapping
    public ResponseEntity<TShirt> createTShirt(@RequestBody TShirt tShirt) {
        TShirt created = tShirtService.createTShirt(tShirt);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT to update a TShirt
    @PutMapping("/{id}")
    public ResponseEntity<TShirt> updateTShirt(@PathVariable Long id, @RequestBody TShirt tShirt) {
        try {
            TShirt updated = tShirtService.updateTShirt(id, tShirt);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE a TShirt
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTShirt(@PathVariable Long id) {
        tShirtService.deleteTShirtById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTShirts(@RequestBody TShirtIds tShirtIds) {
        tShirtService.deleteTShirtsById(tShirtIds.getIds());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Optional: Endpoints for custom queries, e.g., find by colour
    @GetMapping("/search/byColour")
    public ResponseEntity<List<TShirt>> getTShirtsByColour(@RequestParam String colour) {
        List<TShirt> tshirts = tShirtService.findByColour(colour);
        return new ResponseEntity<>(tshirts, HttpStatus.OK);
    }
}
