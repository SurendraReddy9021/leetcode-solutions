import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each number
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Store occurrence counts
        HashSet<Integer> set = new HashSet<>();

        for (int count : map.values()) {
            // If count already exists, occurrences are not unique
            if (!set.add(count)) {
                return false;
            }
        }

        return true;
    }
}