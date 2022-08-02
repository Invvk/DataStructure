package io.github.invvk.ds.stack;

public class StackQuestions {

    public static <T> Stack<T> reverse(Stack<T> stack) {
        Stack<T> s = new Stack<>();
        for (int i = 0; i < s.size(); i++)
            s.push(stack.pop());
        return s;
    }

}
