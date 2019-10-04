package data.structure;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizableQueue<T> implements Iterable<T> {
  private T[] queue;
  private int first, last, size;

  public ResizableQueue() {
    queue = (T[]) new Object[2];
    first = 0;
    last = 0;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean empty() {
    return size == 0;
  }

  public T peek() {
    if (empty()) throw new NoSuchElementException();
    return queue[first];
  }

  public void enqueue(T item) {
    if (size == queue.length) resize(size * 2);
    queue[last++] = item;
    if (last == queue.length) last = 0;
    size++;
  }

  private void resize(int capacity) {
    assert capacity >= size;
    T[] temp = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      temp[i] = queue[(i + first) % queue.length];
    }
    queue = temp;
    first = 0;
    last = size;
  }

  public T dequeu() {
    if (empty()) throw new NoSuchElementException();
    T res = queue[first];
    queue[first++] = null;
    if (first == queue.length) first = 0;
    size--;
    if (size > 0 && size == queue.length / 4) resize(queue.length / 2);
    return res;
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<T> {
    int i = 0;

    @Override
    public boolean hasNext() {
      return i < size;
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      T res = queue[(first + i) % queue.length];
      i++;
      return res;
    }
  }
}
