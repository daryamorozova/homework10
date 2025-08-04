package task8;
/**
8. Поиск второго максимального числа в массиве
Напишите тесты для метода, который находит второе по величине число
Тесты должны проверять:
Обычные массивы
Массив с одинаковыми числами
Один элемент в массиве (должно выбрасываться исключение)
 Пустой массив
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSecondMaxArrayTest {

    private FindSecondMaxArray findSecondMaxArray;

    @BeforeEach
    public void setUpTest() {
        findSecondMaxArray = new FindSecondMaxArray();
    }

    @Test
    public void findSecondMaxWithRegularArray() {
        int[] numbers = {3, 6, 9, 16, 10};
        int expectedResult = 10;
        int actualResult = findSecondMaxArray.findSecondMax(numbers);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findSecondMaxWithNegativeElementArray() {
        int[] numbers = {-3, -6, -9, -16, -10};
        int expectedResult = -6;
        int actualResult = findSecondMaxArray.findSecondMax(numbers);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findSecondMaxWithOneRepeatedElementArray() {
        int[] numbers = {3, 3, 3, 3, 3};
        assertThrows(NoSuchElementException.class, () -> findSecondMaxArray.findSecondMax(numbers));
    }

    @Test
    public void findSecondMaxWithSingleElementArray() {
        int[] numbers = {3};
        assertThrows(NoSuchElementException.class, () -> findSecondMaxArray.findSecondMax(numbers));
    }

    @Test
    public void findSecondMaxWithEmptyArray() {
        int[] numbers = {};
        assertThrows(NoSuchElementException.class, () -> findSecondMaxArray.findSecondMax(numbers));
    }



}
