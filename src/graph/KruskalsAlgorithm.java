package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        // initially everyone's individual node (hence parent to itself)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];    // path compression
            node = parent[node];
        }

        return node;
    }

    public void unionByRank(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if (parent1 == parent2) return;

        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else if (rank[parent2] > rank[parent1]) {
            parent[parent1] = parent2;
        } else {
            parent[parent2] =  parent1;
            rank[parent1] = rank[parent1] + 1;
        }
    }
}
public class KruskalsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static int kruskalsMST(int nodes, List<List<Edge>> adj) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

        for (int i = 0; i < nodes; i++) {
            for (Edge it: adj.get(i)) {
                pq.add(it);
            }
        }
        DisjointSet ds = new DisjointSet(nodes);
        int mstSum = 0;

        while(!pq.isEmpty()) {
            Edge polled = pq.poll();

            if (ds.findParent(polled.src) != ds.findParent(polled.dest)) {
                mstSum += polled.weight;
                ds.unionByRank(polled.src, polled.dest);
            }
        }

        return mstSum;
    }

    // kruskal's without Disjoint Set
    private static int kruskalsWithHashSet(int nodes, List<List<Edge>> adj) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // add all edges to the priority queue
        for (int i = 0; i < nodes; i++) {
            pq.addAll(adj.get(i));
        }

        boolean[] visited = new boolean[nodes];
        // To store the result of MST
        List<Edge> MST = new ArrayList<>();
        int mstSum = 0;

        while (!pq.isEmpty()) {
            Edge polled = pq.poll();
            int start = polled.src;
            int dest = polled.dest;

            // skip the edge if it forms cycle
            if (visited[start] && visited[dest]) continue;

            visited[start] = true;
            visited[dest] = true;

            MST.add(polled);
            mstSum += polled.weight;

        }

        return mstSum;
    }

    public static void main(String[] args) {
        int nodes = 5;
        List<List<Edge>> adj = new ArrayList<>(nodes);

        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Edge(0,1, 6));
        adj.get(0).add(new Edge(0,3, 4));
        adj.get(1).add(new Edge(1,2, 10));
        adj.get(1).add(new Edge(1,3, 7));
        adj.get(1).add(new Edge(1,4, 7));
        adj.get(2).add(new Edge(2,3, 8));
        adj.get(2).add(new Edge(2,4, 5));
        adj.get(3).add(new Edge(3,4, 12));

        int minCost = kruskalsMST(nodes, adj);
//        int minCost = kruskalsWithHashSet(nodes, adj);
        System.out.println("Cost of MST: " + minCost);
    }
}
