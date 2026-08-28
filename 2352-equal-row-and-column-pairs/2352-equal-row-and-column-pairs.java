class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                boolean same = true;

                for (int k = 0; k < n; k++) {

                    if (grid[row][k] != grid[k][col]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    count++;
                }
            }
        }

        return count;
    }
}