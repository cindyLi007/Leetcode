package interview.amazon.online.test;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by ychang on 4/4/2017.
 */
public class SubstringWithAtMostKDistinctCharTest {

  @Test
  public void substringWithKDistinctChar() {
    // Given
    SubstringWithAtMostKDistinctChar substringWithAtMostKDistinctChar = new SubstringWithAtMostKDistinctChar();

    // When
    int result = substringWithAtMostKDistinctChar.substringWithKDistinctChar("abaccc", 2);

    // Then
    assertThat(result, is(4));
  }
}