package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


/**
6. Проверка валидности email
Напишите тесты для метода, который проверяет, является ли строка валидным email:
Тесты должны проверять:
Корректные и некорректные email ("test@example.com", "bad@.com", "no-at-symbol")
null
*/

public class CheckEmailTest {

    private CheckEmail checkEmail;

    @BeforeEach
    public void setUpTest() {
        checkEmail = new CheckEmail();
    }

    public static Stream<Arguments> positiveData() {
        return Stream.of(
                Arguments.of("test@example.com", true),
                Arguments.of("MDA@LAD24.ru", true),
                Arguments.of("test-2@example.com", true));
    }

    public static Stream<Arguments> negativeData() {
        return Stream.of(
                Arguments.of("bad@.com", false),
                Arguments.of("no-at-symbol", false),
                Arguments.of("", false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("positiveData")
    public void userCanCheckEmail(String initialEmail){
        boolean actualResult = checkEmail.isValidEmail(initialEmail);
        Assertions.assertTrue(actualResult);
    }

    @ParameterizedTest
    @MethodSource("negativeData")
    public void userCanCheckNotEven(String initialEmail){
        boolean actualResult = checkEmail.isValidEmail(initialEmail);
        Assertions.assertFalse(actualResult);
    }

}
