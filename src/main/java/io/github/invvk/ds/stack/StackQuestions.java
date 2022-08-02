package io.github.invvk.ds.stack;

import io.github.invvk.ds.queue.Queue;

public class StackQuestions {

    public static <T> Stack<T> reverse(Stack<T> stack) {
        Stack<T> s = new Stack<>();
        for (int i = 0; i < s.size(); i++)
            s.push(stack.pop());
        return s;
    }

    public static <T> Queue<T> fillToQueue(Stack<T> stack) {
        Stack<T> reversed = reverse(stack);
        Queue<T> queue = new Queue<>();
        while (!reversed.isEmpty())
            queue.enqueue(reversed.pop());
        return queue;
    }

}
