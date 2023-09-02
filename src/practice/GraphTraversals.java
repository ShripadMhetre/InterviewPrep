package practice;

import java.util.*;

class Edge {
    int dest;
    int weight;

    public Edge (int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class GraphTraversals {
    /*
        DFS Traversal Implementation
     */
    private static ArrayList<Integer> dfs(int N, List<List<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) dfsUtil(i, adj, visited, ans);
        }

        return ans;
    }
    private static void dfsUtil(int node, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[node] = true;
        ans.add(node);

        for (int neighbour: adj.get(node)) {
            if (!visited[neighbour]) dfsUtil(neighbour, adj, visited, ans);
        }
    }

    /*
        BFS Traversal Implementation
     */
    private static ArrayList<Integer> bfs(int N, List<List<Integer>> adj, int source) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) bfsUtil(adj, queue, visited, i, ans);
        }

        return ans;
    }
    private static void bfsUtil(List<List<Integer>> adj, Queue<Integer> queue, boolean[] visited, int source, ArrayList<Integer> ans) {
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (visited[node]) continue;

            visited[node] = true;
            ans.add(node);

            for (int neigh: adj.get(node)) {
                if (!visited[neigh]) queue.add(neigh);
            }
        }
    }



    /*
        Main Method
     */
    public static void main(String[] args) {
        int nodes = 5;

        List<List<Integer>> adj = new ArrayList<>(nodes);
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        fillUnweightedGraph(adj);

        // DFS Traversal
        ArrayList<Integer> dfsTraversal = dfs(nodes, adj);
        System.out.println("DFS: " + dfsTraversal.toString());

        // BFS Traversal
        ArrayList<Integer> bfsTraversal = bfs(nodes, adj, 0);
        System.out.println("BFS: " + bfsTraversal.toString());

        // Weighted Graph
//        List<List<Edge>> adjW = new ArrayList<>(nodes);
//
//        for (int i = 0; i < nodes; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        fillWeightedGraph(adjW);



//        int ans1 = dijkstra(nodes, adj, 0, 4);
//        System.out.println("Shortest Distance between source and destination: " + ans1);

    }
    private static void fillUnweightedGraph(List<List<Integer>> adj) {
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(2);

        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(3);

        adj.get(3).add(1);
        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(2);
        adj.get(4).add(3);
    }
    private static void fillWeightedGraph(List<List<Edge>> adj) {
        adj.get(0).add(new Edge(1, 4));
        adj.get(0).add(new Edge(2, 8));

        adj.get(1).add(new Edge(0, 4));
        adj.get(1).add(new Edge(2, 2));
        adj.get(1).add(new Edge(3, 6));

        adj.get(2).add(new Edge(0, 8));
        adj.get(2).add(new Edge(1, 2));
        adj.get(2).add(new Edge(4, 9));
        adj.get(2).add(new Edge(3, 5));

        adj.get(3).add(new Edge(1, 6));
        adj.get(3).add(new Edge(2, 5));
        adj.get(3).add(new Edge(4, 4));

        adj.get(4).add(new Edge(2, 9));
        adj.get(4).add(new Edge(3, 4));
    }
}
