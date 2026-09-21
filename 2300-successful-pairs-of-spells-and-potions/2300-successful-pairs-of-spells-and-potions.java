import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        int[] answer = new int[spells.length];
        
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                long product = (long) spells[i] * potions[mid];
                
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            // All potions from 'left' to the end are successful
            answer[i] = potions.length - left;
        }
        
        return answer;
    }
}