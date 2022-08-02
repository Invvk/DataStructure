package io.github.invvk.dstest.queue;

import io.github.invvk.ds.queue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    public void validateQueueMethod() {
        Queue<Integer> queue = new Queue<>();
        int expected = 1;
        queue.enqueue(expected);
        assertEquals(expected, queue.top());
    }

    @Test
    public void validateDequeueMethod() {
        Queue<Integer> queue = new Queue<>();
        int expected = 1;
        queue.enqueue(expected);
        assertEquals(expected, queue.dequeue());
    }

}
