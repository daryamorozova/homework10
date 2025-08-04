package task7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
7. Факториал числа
Напишите тесты для метода, который вычисляет факториал числа
Тесты должны проверять:
        0! = 1
Маленькие числа (1!, 5!, 7!)
Отрицательные числа (должно выбрасываться исключение)
*/
public class CalcFactorialTest {
    private CalcFactorial calcFactorial;

    @BeforeEach
    public void setUpTest() {
        calcFactorial = new CalcFactorial();
    }

    public static Stream<Arguments> positiveData() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(5, 120),
                Arguments.of(7, 5040));
    }

    @ParameterizedTest
    @MethodSource("positiveData")
    public void userCanCheckCountVowels(int n, int expectedResult) {
        int actualResult = calcFactorial.factorial(n);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void userCannotCalculateIfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            calcFactorial.factorial(-1);
        }, "Calculating if number is negative should lead to IllegalArgumentException");
    }
}
