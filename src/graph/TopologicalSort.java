package graph;

import java.util.*;

public class TopologicalSort {
    // Using DFS
    public static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) dfsUtil(i, adj, vis, st);
        }

        int[] topo = new int[V];
        int index = 0;
        while (!st.isEmpty()) {
            topo[index++] = st.pop();
        }

        return topo;
    }

    private static void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (int it: adj.get(node)) {
            if (!vis[it]) dfsUtil(it, adj, vis, st);
        }

        st.push(node);
    }

    // Using BFS :- Kahn's Algorithm
    public static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] in = new int[V];  // array to store indegress of nodes
        int[] topo = new int[V];    // result array to store topological sort order.

        // Setting indegrees by looping over all vertices and incrementing the indegrees of their adjecent nodes.
        for (int i = 0; i < V; i++) {
            for (int it: adj.get(i)) {
                in[it]++;
            }
        }

        // Queue to store BFS order
        Queue<Integer> q = new LinkedList<>();

        // First add the nodes with zero indegree to the queue
        for (int i = 0; i < V; i++) {
            if (in[i] == 0) q.add(i);
        }

        int index = 0;      // varible to keep track of index of topo array.
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;   // adding nodes to topo array as dequeued from queue

            for (int it: adj.get(node)) {
                // subtracting indegree of adjacent nodes by one, as the current node has been processed.
                in[it]--;

                // if indegree becomes zero for any of the adjacent node then add it to queue
                if (in[it] == 0) q.add(it);
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>(Arrays.asList(3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));

//        int[] topo = topoSortBFS(6, adj);
        int[] topo = topoSortDFS(6, adj);
        for (int node: topo) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
