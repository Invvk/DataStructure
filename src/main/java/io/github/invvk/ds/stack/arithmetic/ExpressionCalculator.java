package io.github.invvk.ds.stack.arithmetic;

import io.github.invvk.ds.stack.Stack;

public class ExpressionCalculator {

    private final String expression;

    private ExpressionCalculator(String expression) {
        this.expression = expression;
    }

    public static int calculate(String expression) {
        return new ExpressionCalculator(expression).getResult();
    }

    private String findPostfix() {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        char[] data = expression.toCharArray();

        for (char datum : data) {
            Token token = Token.of(datum);
            if (token.getTokenType() == Token.TokenType.OPERAND) {
                int val = token.getData() - 48;
                postfix.append(val);
            } else if (token.getTokenType() == Token.TokenType.OPERATOR) {
                Character top = stack.top();
                if (!token.comparePriority(top))
                    if (stack.size() > 1)
                        postfix.append(stack.pop()).append(stack.pop());
                    else
                        postfix.append(stack.pop());

                stack.push(token.getData());
            } else if (token.getTokenType() == Token.TokenType.BRACKETS) {
                if (token.getData() == '(') {
                    stack.push(token.getData());
                } else if (token.getData() == ')') {
                    for (int j = 0; j < stack.size(); j++) {
                        char pop = stack.pop();
                        if (pop != '(')
                            postfix.append(pop);
                        else {
                            break;
                        }
                    }
                }
            }
        }
        if (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix.toString();
    }

    public int getResult() {
        final String post = findPostfix();
        final Stack<Integer> istack = new Stack<>();
        final char[] pf = post.toCharArray();

        for (char c : pf) {
            if (Character.isDigit(c)) {
                int val = c - 48;
                istack.push(val);
                continue;
            }
            int num2 = istack.pop();
            int num1 = istack.pop();
            int result = 0;
            switch (c) {
                case '/' -> result += num1 / num2;
                case '*' -> result += num1 * num2;
                case '+' -> result += num1 + num2;
                case '-' -> result += num1 - num2;
            }
            istack.push(result);
        }
        return istack.pop();
    }

}
