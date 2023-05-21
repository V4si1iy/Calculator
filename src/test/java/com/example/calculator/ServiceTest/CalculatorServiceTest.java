package com.example.calculator.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import com.coding.hw_spring_firsttime.Service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class CalculatorServiceTest {
    CalculatorService out = new CalculatorService();
    private static final Integer INTEGER_MAX = Integer.MAX_VALUE;
    private static final Integer INTEGER_MIN = Integer.MIN_VALUE;
    private static final Integer STANDART_NUMBER_1 = 1;
    private static final Integer STANDART_NUMBER_2 = 2;
    private static final Integer ZERO_NUMBER = 0;
    @Test
    public void ShouldWorkWithMaxAndMinNumbersAll()
    {
        assertDoesNotThrow(()-> out.additionCalculator(INTEGER_MAX, INTEGER_MIN));
        assertDoesNotThrow(()-> out.subtractionCalculator(INTEGER_MAX, INTEGER_MIN));
        assertDoesNotThrow(()-> out.divisionCalculator(INTEGER_MAX, INTEGER_MIN));
        assertDoesNotThrow(()-> out.multiplicationCalculator(INTEGER_MAX, INTEGER_MIN));
    }
    @Test
    public void ShouldWorkWithStandartNumbersAll()
    {
        assertEquals(3 , out.additionCalculator(STANDART_NUMBER_1, STANDART_NUMBER_2));
        assertEquals(-1 , out.subtractionCalculator(STANDART_NUMBER_1, STANDART_NUMBER_2));
        assertEquals(2 , out.multiplicationCalculator(STANDART_NUMBER_1, STANDART_NUMBER_2));
        assertEquals(2 , out.divisionCalculator(STANDART_NUMBER_2, STANDART_NUMBER_1));
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSecondNumberIsZeroOnDivision()
    {
        assertThrows(IllegalArgumentException.class , ()-> out.divisionCalculator(STANDART_NUMBER_1, ZERO_NUMBER));



    }
    @ParameterizedTest
    @MethodSource("providedParamsForTestsForAddition")
    public void ShouldWorkWithStandartNumbersAddition(Integer inputNumber1 , Integer inputNumber2, Integer expected)
    {

        assertEquals(expected , out.additionCalculator(inputNumber1, inputNumber2));

    }
    @ParameterizedTest
    @MethodSource("providedParamsForTestsForSubtraction")
    public void ShouldWorkWithStandartNumbersSubtraction(Integer inputNumber1 , Integer inputNumber2, Integer expected)
    {

        assertEquals(expected , out.subtractionCalculator(inputNumber1, inputNumber2));

    }
    @ParameterizedTest
    @MethodSource("providedParamsForTestsForMultiplication")
    public void ShouldWorkWithStandartNumbersMultiplication(Integer inputNumber1 , Integer inputNumber2, Integer expected)
    {

        assertEquals(expected , out.multiplicationCalculator(inputNumber1, inputNumber2));

    }
    @ParameterizedTest
    @MethodSource("providedParamsForTestsForDivision")
    public void ShouldWorkWithStandartNumbersDivision(Integer inputNumber1 , Integer inputNumber2, Double expected)
    {

        assertEquals(expected , out.divisionCalculator(inputNumber1, inputNumber2));

    }

    public static Stream<Arguments> providedParamsForTestsForAddition()
    {
        return Stream.of(
                Arguments.of(STANDART_NUMBER_1,STANDART_NUMBER_2,3),
                Arguments.of(ZERO_NUMBER, STANDART_NUMBER_2, 2)
        );

    }
    public static Stream<Arguments> providedParamsForTestsForSubtraction()
    {
        return Stream.of(
                Arguments.of(STANDART_NUMBER_1,STANDART_NUMBER_2,-1),
                Arguments.of(ZERO_NUMBER, STANDART_NUMBER_2, -2)
        );

    }
    public static Stream<Arguments> providedParamsForTestsForDivision()
    {
        return Stream.of(
                Arguments.of(STANDART_NUMBER_1,STANDART_NUMBER_2,0.5D),
                Arguments.of(ZERO_NUMBER, STANDART_NUMBER_2, 0D)
        );

    }
    public static Stream<Arguments> providedParamsForTestsForMultiplication()
    {
        return Stream.of(
                Arguments.of(STANDART_NUMBER_1,STANDART_NUMBER_2,2),
                Arguments.of(ZERO_NUMBER, STANDART_NUMBER_2, 0)
        );

    }



}
