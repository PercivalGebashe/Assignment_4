package com.github.percivalgebashe.assignment_4.controller;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtFilterDTO;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/web")
public class TShirtWebController {

    private final TShirtService tShirtService;

    public TShirtWebController(TShirtService tShirtService) {
        this.tShirtService = tShirtService;
    }

    @PostMapping(value = "/filter", consumes = "application/x-www-form-urlencoded")
    public String searchTShirts(TShirtFilterDTO filterDTO, Model model) {
        System.out.println("searchTShirts");
        System.out.println(filterDTO);
        List<TShirtDTO> tshirts = tShirtService.getTShirtsByFilters(filterDTO);
        System.out.println(tshirts);
        model.addAttribute("tshirts", tshirts);
        ResponseEntity.ok();
        return "home";
    }

    @GetMapping
    public String getTShirts(Model model) {
        model.addAttribute("tshirts", tShirtService.getTShirts());
        return "home";
    }
}
