
class Solution {
    public int minScore(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];

        return dfs(1, adj, visited, Integer.MAX_VALUE);
    }

    public int dfs(int node, ArrayList<ArrayList<int[]>> adj,
                   boolean[] visited, int min) {

        visited[node] = true;

        for (int[] edge : adj.get(node)) {
            int neighbour = edge[0];
            int weight = edge[1];

            min = Math.min(min, weight);

            if (!visited[neighbour]) {
                min = dfs(neighbour, adj, visited, min);
            }
        }

        return min;
    }
}
