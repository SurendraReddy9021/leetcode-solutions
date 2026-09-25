import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        // Graph: variable -> (neighbor, value)
        Map<String, List<Pair>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Pair(b, values[i]));
            graph.get(b).add(new Pair(a, 1.0 / values[i]));
        }

        double[] answer = new double[queries.size()];

        // Solve each query using DFS
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(start, end, graph, visited);
            }
        }

        return answer;
    }

    private double dfs(String current,
                       String target,
                       Map<String, List<Pair>> graph,
                       Set<String> visited) {

        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        for (Pair edge : graph.get(current)) {
            if (!visited.contains(edge.node)) {

                double result = dfs(edge.node, target, graph, visited);

                if (result != -1.0) {
                    return edge.value * result;
                }
            }
        }

        return -1.0;
    }

    static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}