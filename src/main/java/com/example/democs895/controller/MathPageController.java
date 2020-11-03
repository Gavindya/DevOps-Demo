package com.example.democs895.controller;

import com.example.democs895.model.FindEquation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("request")
public class MathPageController {

    private FindEquation findEquation;

    public MathPageController(FindEquation findEquation) {

        this.findEquation = findEquation;
    }

    @GetMapping(value = "/sum")
    public String additionPage(Model model,
                               @RequestParam(name = "x") int x_val,
                               @RequestParam(name = "y") int y_val) {
        model.addAttribute("func", "Addition");
        model.addAttribute("x", String.valueOf(x_val));
        model.addAttribute("y", String.valueOf(y_val));
        model.addAttribute("answer", findEquation.additionFunc(x_val, y_val));
        return "mathpage";
    }

    @GetMapping(value = "/mul")
    public String multiplicationPage(Model model,
                                     @RequestParam(name = "x") int x_val,
                                     @RequestParam(name = "y") int y_val) {
        model.addAttribute("func", "Multiplication");
        model.addAttribute("x", String.valueOf(x_val));
        model.addAttribute("y", String.valueOf(y_val));
        model.addAttribute("answer", findEquation.multiplicationFunc(x_val, y_val));
        return "mathpage";
    }

    @GetMapping(value = "/sub")
    public String subtractPage(Model model,
                               @RequestParam(name = "x") int x_val,
                               @RequestParam(name = "y") int y_val) {
        model.addAttribute("func", "Subtraction");
        model.addAttribute("x", String.valueOf(x_val));
        model.addAttribute("y", String.valueOf(y_val));
        model.addAttribute("answer", findEquation.subtractFunc(x_val, y_val));
        return "mathpage";
    }
}

