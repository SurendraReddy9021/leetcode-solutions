class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});

        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;
        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Check boundaries
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Wall or already visited
                    if (maze[nr][nc] == '+') {
                        continue;
                    }

                    // If this is an open boundary cell, it is the nearest exit
                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                        return steps;
                    }

                    maze[nr][nc] = '+';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}