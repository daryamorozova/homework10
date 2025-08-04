package task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
9. Подсчёт количества слов в строке
Напишите тесты для метода, который считает количество слов в строке:
Тесты должны проверять:
Пустую строку
null
Строку с несколькими пробелами
*/
public class CountWordsTest {

    private CountWords countWords;

    @BeforeEach
    public void setUpTest(){
        countWords = new CountWords();
    }

@ParameterizedTest
@CsvSource({
        "'This is a test', 4",
        "'This   is   a   test', 4",
        "'', 0",
        "'     ', 0"
})
public void countWordsWithVariousInputs(String sentence, int expectedResult) {
    int actualResult = countWords.countWords(sentence);
    assertEquals(expectedResult, actualResult);
}

    @Test
    public void countWordsTestWithNull(){
        assertThrows(IllegalArgumentException.class, () -> countWords.countWords(null));
    }





}
