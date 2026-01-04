package JAVA.SHASHCODE.LECTURE122;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class First_negative_in_every_window_of_size_k {
    public static long[] firstNegInt(long arr[], int k) {
        // write code here
        int N = arr.length;
        Queue<Long> queue = new LinkedList<Long>();
        int index = 0;
        while (index < k) {
            if (arr[index] < 0) {
                queue.offer(arr[index]);
            }
            index++;
        }
        long res[] = new long[N - k + 1];
        res[0] = (queue.isEmpty()) ? 0 : queue.peek();
        for (int i = 1; i < N - k + 1; i++) {
            // remove
            if (arr[i - 1] < 0) {
                queue.poll();
            }
            // add
            if (arr[i + k - 1] < 0) {
                queue.offer(arr[i + k - 1]);
            }
            res[i] = (queue.isEmpty()) ? 0 : queue.peek();
        }
        return res;
    }

    // same code but using lint<Integer>
    static List<Integer> firstNegInt(int arr[], int k) {
        int N = arr.length;
        List<Integer> result = new ArrayList<>();

        if (k <= 0 || k > N)
            return result;

        Deque<Integer> queue = new ArrayDeque<>();

        // Process first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.offer(i); // store index
            }
        }

        // Add result for first window
        result.add(queue.isEmpty() ? 0 : arr[queue.peek()]);

        // Process remaining windows
        for (int i = k; i < N; i++) {

            // Remove elements out of this window
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            // Add current element if negative
            if (arr[i] < 0) {
                queue.offer(i);
            }

            result.add(queue.isEmpty() ? 0 : arr[queue.peek()]);
        }

        return result;
    }

}
