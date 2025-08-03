package task4;
/**4. Поиск максимального числа в массиве
 * Напишите тесты для метода, который находит максимальное число в массиве:
 *Тесты должны проверять:
 * Обычный массив ([3, 5, 7, 2])
 * Один элемент в массиве
 * Отрицательные числа
 * Пустой массив (должно выбрасываться исключение) *
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindMaxTest {
    private FindMaxOfArray findMax;

    @BeforeEach
    public void setUpTest() {
       findMax = new FindMaxOfArray();
    }

    @Test
    public void findMaxWithRegularArray() {
        int[] numbers = {3, 6, 9, 16, 10};
        int expectedResult = 16;
        int actualResult = findMax.findMax(numbers);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findMaxWithSingleElementArray() {
        int[] numbers = {10};
        int expectedResult = 10;
        int actualResult = findMax.findMax(numbers);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findMaxWithNegativeElementArray() {
        int[] numbers = {-3, -6, -9, -16, -10};
        int expectedResult = -3;
        int actualResult = findMax.findMax(numbers);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findMaxWithEmptyArray() {
        int[] numbers = {};
        assertThrows(NoSuchElementException.class, () -> findMax.findMax(numbers));

    }


}
