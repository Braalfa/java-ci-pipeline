import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Tests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4, calculator.sum(3, 1), "3 + 1 should equal 4");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    10,   10",
            "3,    7,   10",
            "100,  210, 310",
            "99,  77, 176"
    })
    void add(double first, double second, int expectedResult) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(expectedResult, calculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("1 - 1 = 0")
    void restTwoNumbers() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(0, calculator.rest(1, 1), "1 - 1 should equal 0");
    }

    @ParameterizedTest(name = "{3} - {1} = {2}")
    @CsvSource({
            "10,    50,   -40",
            "7,    2,   5",
            "100,  60, 40",
            "99,  9, 90"
    })
    void rest(double first, double second, double expectedResult) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(expectedResult, calculator.rest(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("10 * 3 = 30")
    void multiplyTwoNumbers() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(30, calculator.multiplication(10, 3), "10 * 3 should equal 30");
    }

    @ParameterizedTest(name = "{3} * {1} = {3}")
    @CsvSource({
            "10,    50,   500",
            "7,    2,   14",
            "100,  60, 6000",
            "99,  9, 891"
    })
    void multiply(double first, double second, double expectedResult) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(expectedResult, calculator.multiplication(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("100 / 5 = 20")
    void devideTwoNumbers() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(20, calculator.divide(100, 5), "100 / 5 should equal 20");
    }

    @ParameterizedTest(name = "{100} / {5} = {20}")
    @CsvSource({
            "100,    5,   20",
            "7,    2,   3.5",
            "-100,  50, -2",
            "99,  9, 11"
    })
    void divide(double first, double second, double expectedResult) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(expectedResult, calculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }
}
