import java.util.*;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // Add current request
        queue.offer(t);

        // Remove requests older than 3000 ms
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Number of requests in [t - 3000, t]
        return queue.size();
    }
}