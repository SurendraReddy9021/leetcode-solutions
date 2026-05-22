class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Search in right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }

            // Search in left half
            else {
                right = mid - 1;
            }
        }

        // Position where target should be inserted
        return left;
    }
}