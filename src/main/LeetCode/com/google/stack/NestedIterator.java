package com.google.stack;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.google.stack.NestedInteger;

/**
 * Created by ychang on 1/9/2017. This can beat 95%
 */
public class NestedIterator implements Iterator<Integer> {
    /**
     * this is the correct way, stack only save "pointers to each layer NestedList"
     * we use ListIterator because it can move the cursor position backward
     */
    private Stack<ListIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        /**
         * call hasNext() in next() in case user does not call hasNext() before, we need use hasNext to pre-process iterator
         */
        hasNext();
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                // if current iterator run out of elements, this is the only case we pop iterator
                stack.pop();
            } else {
                NestedInteger x = stack.peek().next(); // pick top iterator's next element
                if (x.isInteger()) {
                    stack.peek().previous(); // move back cursor position
                    return true;
                }
                stack.push(x.getList().listIterator()); // go to deeper layer
            }
        }
        return false;
    }
}
