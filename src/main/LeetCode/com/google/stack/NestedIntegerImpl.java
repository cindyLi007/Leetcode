package com.google.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 2/21/2017.
 */
public class NestedIntegerImpl implements NestedInteger {
  Integer value;
  List<NestedInteger> list = new LinkedList<>();

  public NestedIntegerImpl() {
  }

  @Override
  public boolean isInteger() {
    return value!=null;
  }

  public NestedIntegerImpl(int value) {
    this.value = value;
  }

  @Override
  public Integer getInteger() {
    return value;
  }

  @Override
  public void setInteger(int value) {
  }

  @Override
  public void add(NestedInteger ni) {
    list.add(ni);
  }

  @Override
  public List<NestedInteger> getList() {
    return list;
  }
}
