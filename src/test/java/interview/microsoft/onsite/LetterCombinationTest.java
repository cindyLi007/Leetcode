package interview.microsoft.onsite;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 8/21/2017.
 */
public class LetterCombinationTest {
  @Test
  public void letterCombination() throws Exception {
    // Given
    LetterCombination letterCombination = new LetterCombination();

    // When
    List<String> list = letterCombination.letterCombination("70309363");

    // Then
    list.forEach(System.out::println);
  }

}