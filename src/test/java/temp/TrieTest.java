package temp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/12/2017.
 */
public class TrieTest {
  @Test
  public void insert() throws Exception {
    // Given
    Trie trie = new Trie();
    trie.insert("ab");

    // When
    boolean search = trie.search("a");
    boolean startsWith = trie.startsWith("a");

    // Then
    assertThat(search, is(Boolean.FALSE));
    assertThat(startsWith, is(Boolean.TRUE));
  }

}