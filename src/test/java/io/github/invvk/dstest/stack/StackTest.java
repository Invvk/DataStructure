package io.github.invvk.dstest.stack;

import io.github.invvk.ds.stack.Stack;
import io.github.invvk.ds.stack.arithmetic.ExpressionCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource({"'9*(5+4/2-1)*3',162", "'1+1',2", "'1+2*2+1',6"})
    public void validateArithmetic(String expression, int expectedResult) {
        int result = ExpressionCalculator.calculate(expression);
        assertEquals(expectedResult, result);
    }

}
