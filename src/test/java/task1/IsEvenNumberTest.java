package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


//1. Проверка чётности числа
//Напишите тесты для метода, который определяет, является ли число чётным

//Тесты должны проверять:
//Чётные и нечётные числа
//Нулевое значение
//Отрицательные числа

public class IsEvenNumberTest {

    /**
     * Тесты для проверки четности:
     *  happy path:
     *      4 -> true
     *      -6 -> true
     *      0 -> true
     *  negative:
     *      5 -> false
     *      -5 -> false
     */

    private EvenNumber evenNumber;

    @BeforeEach
    public void setUpTest() {
        evenNumber = new EvenNumber();
    }

    public static Stream<Arguments> validData() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(-6, true),
                Arguments.of(0, true));
    }

    public static Stream<Arguments> invalidData() {
        return Stream.of(
                Arguments.of(5, false),
                Arguments.of(-5, false));
    }

    @ParameterizedTest
    @MethodSource("validData")
    public void userCanCheckEven(int initialNumber){
        boolean result = evenNumber.isEven(initialNumber);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("invalidData")
    public void userCanCheckNotEven(int initialNumber){
        boolean result = evenNumber.isEven(initialNumber);
        Assertions.assertFalse(result);
    }

}
