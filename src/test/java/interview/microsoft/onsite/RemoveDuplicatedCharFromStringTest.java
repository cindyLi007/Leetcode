package interview.microsoft.onsite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/21/2017.
 */
public class RemoveDuplicatedCharFromStringTest {
  @Test
  public void removeDuplicatedCharFromString() throws Exception {
    // Given
    RemoveDuplicatedCharFromString removeDuplicatedCharFromString = new RemoveDuplicatedCharFromString();

    // When
    String res = removeDuplicatedCharFromString.removeDuplicatedCharFromString("aaaaaaaa");

    // Then
    assertThat(res, is("a"));
  }

}