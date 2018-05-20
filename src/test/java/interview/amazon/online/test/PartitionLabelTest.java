package interview.amazon.online.test;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

/**
 * Created by ychang on 5/5/2018.
 */
public class PartitionLabelTest {

  @Test
  public void partitionLabels() {
    // Given
    String s = "ababcbacadefegdehijhklij";
    PartitionLabel partitionLabel = new PartitionLabel();

    // When
    List<Integer> resultList = partitionLabel.partitionLabels(s);

    // Then
    assertThat(resultList, contains(9, 7, 8));
  }
}