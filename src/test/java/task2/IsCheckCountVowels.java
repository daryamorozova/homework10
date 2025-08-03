package task2;

//Напишите тесты для метода, который считает количество гласных букв в строке
//Тесты должны проверять:
//Разные строки ("hello", "java", "AEIOUY", "")
//null (должно выбрасываться исключение)
//Строки без гласных


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsCheckCountVowels {

    /**
     * Тесты на подсчет гласных
     *  позитивные сценарии
     *     "hello" -> 2
     *     "java" -> 2
     *     "AEIOUY" -> 6
     *     "grrr" -> 0
     *  угловые сценарии
     *     "" -> 0
     *     null -> IllegalArgumentException
     */

 private СountVowels countVowels;

 @BeforeEach
    public void setUpTest() {
     countVowels = new СountVowels();
 }

 private static Stream<Arguments> provideTestCases() {
     return Stream.of(
             Arguments.of("hello", 2),
             Arguments.of("java", 2),
             Arguments.of("AEIOUY", 6),
             Arguments.of("grrr", 0),
             Arguments.of("", 0)
     );
 }

@ParameterizedTest
@MethodSource("provideTestCases")
public void userCanCheckCountVowels(String initialString, int expectedResult) {
     int actualResult = countVowels.countVowels(initialString);
     assertEquals(expectedResult, actualResult);
}

@Test
    public void userCannotCheckIfNullString() {
     assertThrows(IllegalArgumentException.class, () -> {
         countVowels.countVowels(null);
     }, "Checking if string is null should lead to IllegalArgumentException");
}




}
