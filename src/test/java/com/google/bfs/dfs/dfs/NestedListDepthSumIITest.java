package com.google.bfs.dfs.dfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import com.google.common.collect.Lists;
import com.google.stack.NestedInteger;
import com.google.stack.NestedIntegerImpl;

/**
 * Created by ychang on 2/21/2017.
 */
public class NestedListDepthSumIITest {
  @Mock
  NestedInteger mockInteger1, mockInteger2, mockInteger3;

  @Test
  public void depthSumInverse() throws Exception {
    // Given
    NestedIntegerImpl nii = new NestedIntegerImpl();
    NestedIntegerImpl nii_1 = new NestedIntegerImpl();
    nii_1.add(new NestedIntegerImpl(1)); nii_1.add(new NestedIntegerImpl(1));
    nii.add(nii_1);
    nii.add(new NestedIntegerImpl(2));
    NestedIntegerImpl nii_2 = new NestedIntegerImpl();
    nii_2.add(new NestedIntegerImpl(1)); nii_2.add(new NestedIntegerImpl(1));
    nii.add(nii_2);
    List<NestedInteger> list = Lists.newArrayList();
    list.add(nii_1);
    list.add(new NestedIntegerImpl(2));
    list.add(nii_2);
    NestedListDepthSumII nlds = new NestedListDepthSumII();

    // when
    int res = nlds.depthSumInverse_recursive(list);

    // Then
    assertThat(res, is(8));
  }

}