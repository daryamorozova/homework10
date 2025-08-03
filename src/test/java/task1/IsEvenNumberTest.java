package task1;

//1. Проверка чётности числа
//Напишите тесты для метода, который определяет, является ли число чётным

//Тесты должны проверять:
//Чётные и нечётные числа
//Нулевое значение
//Отрицательные числа

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    public static Stream<Arguments> positiveData() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(-6, true),
                Arguments.of(0, true));
    }

    public static Stream<Arguments> negativeData() {
        return Stream.of(
                Arguments.of(5, false),
                Arguments.of(-5, false));
    }

    @ParameterizedTest
    @MethodSource("positiveData")
    public void userCanCheckEven(int initialNumber){
        boolean actualResult = evenNumber.isEven(initialNumber);
        Assertions.assertTrue(actualResult);
    }

    @ParameterizedTest
    @MethodSource("negativeData")
    public void userCanCheckNotEven(int initialNumber){
        boolean actualResult = evenNumber.isEven(initialNumber);
        Assertions.assertFalse(actualResult);
    }



}
