package com.coding.hw_spring_firsttime.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.coding.hw_spring_firsttime.Service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class Calculator {

    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting() {
        return calculatorService.greetingCalculator();
    }

    @GetMapping("/plus")
    public String addition(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + " + " + num2 + " = " + calculatorService.additionCalculator(num1, num2);
    }

    @GetMapping("/minus")
    public String subtraction(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + " - " + num2 + " = " + calculatorService.subtractionCalculator(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiplication(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + " * " + num2 + " = " + calculatorService.multiplicationCalculator(num1, num2);
    }

    @GetMapping("/divide")
    public String division(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + " / " + num2 + " = " + calculatorService.divisionCalculator(num1, num2);
    }
}
