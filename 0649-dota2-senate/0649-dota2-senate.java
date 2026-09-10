import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store positions of senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Continue until one party has no senators
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                // Radiant senator acts first
                radiant.offer(r + n);
            } else {
                // Dire senator acts first
                dire.offer(d + n);
            }
        }

        // The party with senators remaining wins
        if (radiant.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}