package io.github.invvk.ds.stack.arithmetic;

import io.github.invvk.ds.stack.Stack;

public class ExpressionCalculator {

    public static int calculate(String expression) {
        if (expression.isEmpty())
            return 0;
        char[] tokens = expression.toCharArray();
        Stack<Character> opstack = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            char token = tokens[i];

            // ignore whitespaces
            if (token == ' ')
                continue;

            if (token <= '9' && token >= '0') {
                StringBuilder sb = new StringBuilder();

                while (i < tokens.length && tokens[i] <= '9' && tokens[i] >= '0')
                    sb.append(tokens[i++]);

                values.push(Integer.parseInt(sb.toString()));
                i--;
            } else if (token == '(')
                opstack.push(token);
            else if (token == ')') {
                while (opstack.top() != '(')
                    values.push(applyOperation(values.pop(), values.pop(), opstack.pop()));

                // get rid of '('
                opstack.pop();
            } else if (token == '*' || token == '/' || token == '+' || token == '-') {
                while (!opstack.isEmpty() && hasPrecedence(token, opstack.top()))
                    values.push(applyOperation(values.pop(), values.pop(), opstack.pop()));
                opstack.push(token);
            }
        }
        while (!opstack.isEmpty())
            values.push(applyOperation(values.pop(), values.pop(), opstack.pop()));
        return values.pop();
    }

    private static boolean hasPrecedence(char input1, char input2) {
        if (input2 == '(' || input2 == ')')
            return false;
        return (input1 != '*' && input1 != '/') || (input2 != '+' && input2 != '-');
    }

    private static int applyOperation(int y, int x, char operation) {
        switch (operation) {
            case '*' -> { return x * y; }
            case '/' -> { return x / y; }
            case '+' -> { return x + y; }
            case '-' -> { return x - y; }
            default -> throw new IllegalArgumentException(String.format("invalid operator '%c'", operation));
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("8 + 2 * 3 + (2 - 1 / 1) * 9 * 1000"));
        System.out.println(calculate("1+1*2"));
    }

}
