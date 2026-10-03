import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        
        // Store {nums2[i], nums1[i]}
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        
        // Sort by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        // Min-heap for nums1 values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long sum = 0;
        long answer = 0;
        
        for (int i = 0; i < n; i++) {
            
            sum += pairs[i][1];
            minHeap.offer(pairs[i][1]);
            
            // Keep exactly k elements
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            // When we have k elements
            if (minHeap.size() == k) {
                answer = Math.max(answer, sum * pairs[i][0]);
            }
        }
        
        return answer;
    }
}