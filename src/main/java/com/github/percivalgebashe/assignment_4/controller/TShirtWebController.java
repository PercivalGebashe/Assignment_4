
package com.github.percivalgebashe.assignment_4.controller;

import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.service.TShirtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/web")
public class TShirtWebController {

    private final TShirtService tShirtService;

    public TShirtWebController(TShirtService tShirtService) {
        this.tShirtService = tShirtService;
    }

    @GetMapping
    public String showTShirtsPage(Model model) {
        List<TShirt> tshirts = tShirtService.getAllTShirts();
        model.addAttribute("tshirts", tshirts);
        System.out.println(tshirts);
        return "home";
    }
}
