class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            // Original direction: from -> to
            graph[from].add(new int[]{to, 1});

            // Reverse direction: to -> from
            graph[to].add(new int[]{from, 0});
        }

        return dfs(0, -1, graph);
    }

    private int dfs(int node, int parent, List<int[]>[] graph) {
        int count = 0;

        for (int[] edge : graph[node]) {
            int next = edge[0];
            int needsChange = edge[1];

            if (next == parent) {
                continue;
            }

            count += needsChange;
            count += dfs(next, node, graph);
        }

        return count;
    }
}