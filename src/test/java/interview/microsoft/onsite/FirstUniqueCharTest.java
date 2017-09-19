package interview.microsoft.onsite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/21/2017.
 */
public class FirstUniqueCharTest {
  @Test
  public void firstUniqueChar() throws Exception {
    // Given
    FirstUniqueChar firstUniqueChar = new FirstUniqueChar();

    // When
    int pos = firstUniqueChar.firstUniqueChar("abbbccadd");

    // Then
    assertThat(pos, is(-1));
  }

}