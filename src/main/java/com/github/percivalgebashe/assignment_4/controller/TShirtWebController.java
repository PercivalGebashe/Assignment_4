package com.github.percivalgebashe.assignment_4.controller;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/web")
public class TShirtWebController {

    private final TShirtService tShirtService;

    public TShirtWebController(TShirtService tShirtService) {
        this.tShirtService = tShirtService;
    }

    @GetMapping
    public String showTShirtsPage(Model model,
                                  @RequestParam(required = false) String colour,
                                  @RequestParam(required = false) Character gender,
                                  @RequestParam(required = false) Character size,
                                  @RequestParam(required = false) Double minPrice,
                                  @RequestParam(required = false) Double maxPrice,
                                  @RequestParam(required = false) Double minRating) {

        List<TShirtDTO> tshirts = tShirtService.getTShirtsByFilters(colour, gender, size, minPrice, maxPrice, minRating);
        model.addAttribute("tshirts", tshirts);
        return "home"; // Loads "tshirts.html" from templates/
    }
}
