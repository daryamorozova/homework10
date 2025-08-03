package task5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

/** Напишите тесты для метода, который определяет, является ли год високосным:
 * Тесты должны проверять:
 * Обычные годы
 * Високосные (2020, 2000, 1600)
 * Года, которые делятся на 100, но не на 400 (1900, 2100)
 */


public class LeapYearTests {

    /**
     * Тесты для проверки високосного года:
     *  happy path:
     *      2024 -> true
     *      2020 -> true
     *      0 -> true
     *  negative:
     *      2021 -> false
     *      1900 -> false
     *      2025 -> false
     *      <0 -> IllegalArgumentException
     */

    private LeapYear leapYear;

    @BeforeEach
    public void setUpTest() {
        leapYear = new LeapYear();
    }

    public static Stream<Arguments> positiveData() {
        return Stream.of(
                Arguments.of(2024, true),
                Arguments.of(2020, true),
                Arguments.of(0, true));
    }

    public static Stream<Arguments> negativeData() {
        return Stream.of(
                Arguments.of(2021, false),
                Arguments.of(1900, false),
                Arguments.of(2025, false));
    }

    @ParameterizedTest
    @MethodSource("positiveData")
    public void userCanCheckIsLeap(int initialYear){
        boolean actualResult = leapYear.isLeapYear(initialYear);
        Assertions.assertTrue(actualResult);
    }

    @ParameterizedTest
    @MethodSource("negativeData")
    public void userCanCheckIsNotLeap(int initialYear){
        boolean actualResult = leapYear.isLeapYear(initialYear);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void userCannotCheckIfNegativeYear(){
        assertThrows(IllegalArgumentException.class, () -> {
                leapYear.isLeapYear(-1);
    }, "Checking if year is negative should lead to IllegalArgumentException");
    }

}
