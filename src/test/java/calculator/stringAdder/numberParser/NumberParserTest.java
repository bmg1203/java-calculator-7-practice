package calculator.stringAdder.numberParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 17.
 */
class NumberParserTest {

  private NumberParser numberParser;

  @BeforeEach
  void setUp(){
    numberParser = new NumberParser();
  }

  @Test
  void getNumbers_defaultDelimiters_success() {
    String input = String.valueOf(Long.MAX_VALUE)+",1,2:3";
    String[] delimiters = {",", ":"};
    String[] expected = {String.valueOf(Long.MAX_VALUE), "1", "2", "3"};

    assertArrayEquals(expected, numberParser.getNumbers(input, delimiters));
  }

  @Test
  void getNumbers_customDelimiters_success() {
    String input = "//;\\n"+String.valueOf(Long.MAX_VALUE)+",2;3";
    String[] delimiters = {",", ":",";"};
    String[] expected = {String.valueOf(Long.MAX_VALUE), "2", "3"};

    assertArrayEquals(expected, numberParser.getNumbers(input, delimiters));
  }

  @Test
  void getNumbers_exceedLongRange_success() {
    String input = "//;\\n"+String.valueOf(Long.MAX_VALUE)+"9474747474723459237"+",2;3";
    String[] delimiters = {",", ":",";"};
    String[] expected = {String.valueOf(Long.MAX_VALUE)+"9474747474723459237", "2", "3"};

    assertArrayEquals(expected, numberParser.getNumbers(input, delimiters));
  }

  @Test
  void getNumbers_negativeNumber_fail() {
    String input = String.valueOf(Long.MAX_VALUE)+",-1,2,3";
    String[] delimiters = {",", ":","$"};

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      numberParser.getNumbers(input, delimiters);
    });

    String expectedMessage = "NumberParser: 음수는 허용되지 않습니다: -1";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}