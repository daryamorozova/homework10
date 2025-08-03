package task3;
/**
3. Разворот строки
Напишите тесты для метода, который переворачивает строку:
Тесты должны проверять:
Обычные строки
Пустую строку
null (должно возвращаться null)
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseStringTest {

    private ReverseString reversedString;
    @BeforeEach
    public void setUpTest() {
        reversedString = new ReverseString();
    }

    /**
     * Тесты для переворота строки:
     *  happy path: "dasha" -> "ahsad"
     *  corner cases:
     *        "" -> ""
     *        "d" -> "d"
     *        null -> null
     */
    public static Stream<Arguments> validStringsToReverse() {
        return Stream.of(
                // happy path: "dasha" -> "ahsad"
                Arguments.of("dasha", "ahsad"),
                // corner cases: "" -> ""
                Arguments.of("", ""),
                // corner cases: "d" -> "d"
                Arguments.of("d", "d"));
    }

    @ParameterizedTest
    @MethodSource("validStringsToReverse")
    public void userCanReverseValidString(String initialString, String expectedString){
        String actualResult = reversedString.reverse(initialString);
        assertEquals(expectedString, actualResult, "String reversed incorrectly!");
    }

    @Test
    public void userReverseNullString(){
        assertNull(reversedString.reverse(null), "String is null!");
    }


}
