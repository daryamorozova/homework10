package task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


    @Test
    public void countWordsWithRegularSentence() {
        String sentence = "This is a test";
        int expectedResult = 4;
        int actualResult = countWords.countWords(sentence);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordsWithSentenceWithSpaces() {
        String sentence = "This   is   a   test";
        int expectedResult = 4;
        int actualResult = countWords.countWords(sentence);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordsWithEmpty() {
        String sentence = "";
        int expectedResult = 0;
        int actualResult = countWords.countWords(sentence);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordsWithEmptySpaces() {
        String sentence = "     ";
        int expectedResult = 0;
        int actualResult = countWords.countWords(sentence);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordsWithNull() {
        assertThrows(IllegalArgumentException.class, () -> countWords.countWords(null));
    }

}
