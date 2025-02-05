package com.github.percivalgebashe.assignment_4.controller;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtFilterDTO;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tshirts")
public class TShirtRestController {

    private final TShirtService tShirtService;

    public TShirtRestController(TShirtService tShirtService) {
        this.tShirtService = tShirtService;
    }

    @PostMapping(value = "/filter", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<HttpStatus> getTShirtByFilter(TShirtFilterDTO filterDTO, Model model) {
        List<TShirtDTO> filteredShirts = tShirtService.getTShirtsByFilters(filterDTO);
        model.addAttribute("filteredShirts", filteredShirts);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TShirtDTO>> getTShirts() {
        List<TShirtDTO> tshirts = tShirtService.getTShirts();
        return ResponseEntity.ok(tshirts);
    }

//    @PostMapping(value = "/ids", consumes = "application/json")
//    public ResponseEntity<List<TShirtDTO>> getTShirtsByIds(@RequestBody List<TShirtIdDTO> ids) {
//        List<TShirtDTO> tShirtDTOs = tShirtService.findAll(ids);
//        return ResponseEntity.ok(tShirtDTOs);
//    }
}