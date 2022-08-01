package io.github.invvk.dstest.stack;

import io.github.invvk.ds.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    @Test
    public void validatePush() {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        stack.push(expected);
        assertEquals(expected, stack.top());
    }

    @Test
    public void validatePop() {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        stack.push(expected);
        assertEquals(expected, stack.pop());
    }

}
