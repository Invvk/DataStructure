package io.github.invvk.ds.stack.arithmetic;

public class Token {

    private final TokenType tokenType;
    private char data;

    private int priority;

    enum TokenType {
        OPERATOR, OPERAND, BRACKETS
    }

    public static Token of(char data) {
        if (Character.isDigit(data))
            return new Token(TokenType.OPERAND, data);

        if (data == '(' || data == ')') {
            return new Token(TokenType.BRACKETS, data);
        }
        return new Token(TokenType.OPERATOR, data);
    }

    private Token(TokenType tokenType, char data) {
        this.tokenType = tokenType;
        this.data = data;
        if (tokenType == TokenType.BRACKETS || tokenType == TokenType.OPERATOR)
            priority = findPriority(data);
    }

    public int getPriority() {
        return priority;
    }

    public char getData() {
        return data;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setData(char data) {
        this.data = data;
    }

    public boolean comparePriority(Character input) {
        if (input == null)
            return true;
        return findPriority(input) < getPriority();
    }

    public int findPriority(char find) {
        switch (find) {
            case ')' -> { return 4; }
            case '(' -> { return 0; }
            case '*', '/' -> { return 2; }
            case '+', '-' -> { return 1; }
        }
        throw new IllegalArgumentException("invalid operator");
    }
}
