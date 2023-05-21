package com.coding.hw_spring_firsttime.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String greetingCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    public Integer additionCalculator(Integer num, Integer num2) {
        return num + num2;
    }

    public Integer subtractionCalculator(Integer num, Integer num2) {
        return num - num2;
    }

    public Integer multiplicationCalculator(Integer num, Integer num2) {
        return num * num2;
    }

    public Double divisionCalculator(Integer num, Integer num2) {
        if (num2 == 0) throw new IllegalArgumentException();
        return (double) num / (double) num2;


    }
}
