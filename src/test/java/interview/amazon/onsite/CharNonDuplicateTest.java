package interview.amazon.onsite;

import org.junit.Test;

/**
 * Created by ychang on 4/4/2017.
 */
public class CharNonDuplicateTest {
  @Test
  public void input() throws Exception {
    // Given
    CharNonDuplicate charNonDuplicate = new CharNonDuplicate();

    // When
    charNonDuplicate.input('a');
    charNonDuplicate.input('b');
    charNonDuplicate.input('c');

    // Then
    System.out.println(charNonDuplicate.latestNonDuplicated());

    // When
    charNonDuplicate.input('c');
    System.out.println(charNonDuplicate.latestNonDuplicated());
    charNonDuplicate.input('d');
    System.out.println(charNonDuplicate.latestNonDuplicated());
    charNonDuplicate.input('d');
    System.out.println(charNonDuplicate.latestNonDuplicated());

    // When
    charNonDuplicate.input('b');
    System.out.println(charNonDuplicate.latestNonDuplicated());
    charNonDuplicate.input('a');
    System.out.println(charNonDuplicate.latestNonDuplicated());
    charNonDuplicate.input('e');
    System.out.println(charNonDuplicate.latestNonDuplicated());

  }

}