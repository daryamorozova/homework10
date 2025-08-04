package task10;
/**
10. Проверка валидности номера телефона
Напишите тесты для метода, который проверяет валидность телефонного номера:
Тесты должны проверять:
Корректные номера ("+1 1234567890")
Некорректные номера ("12345", "invalid")
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CheckPhoneNumberTest {
    private CheckPhoneNumber checkPhoneNumber;

    @BeforeEach
    public void setUpTest() {
        checkPhoneNumber = new CheckPhoneNumber();
    }

    @ParameterizedTest
    @CsvSource({
            "'+7 9875552369', true",
            "'+66 9876662111', true",
            "'+777 6565656564', true",
            "'     ', false",
            "'', false",
            "'56984', false",
            "'notANumber', false",
            "'+8juyty', false",
            "'+7757 6565656564', false",
            "'+775 656564', false",
    })
    public void countWordsWithVariousInputs(String number, boolean expectedResult) {
        boolean actualResult = checkPhoneNumber.isValidPhoneNumber(number);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordsWithNull() {
        assertThrows(IllegalArgumentException.class, () -> checkPhoneNumber.isValidPhoneNumber(null));
    }



}
