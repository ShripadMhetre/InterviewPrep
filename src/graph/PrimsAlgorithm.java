package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    private static int mst(int nodes, List<List<Edge>> adj, int source) {
        boolean[] visited = new boolean[nodes];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

        visited[source] = true;

        for (Edge it: adj.get(source)) {
            minHeap.add(it);
        }

        int minCost = 0;
        while (!minHeap.isEmpty()) {
            Edge minEdge = minHeap.poll();

            if (visited[minEdge.dest]) continue;

            visited[minEdge.dest] = true;

            minCost += minEdge.weight;

            for (Edge it: adj.get(minEdge.dest)) {
                if (!visited[it.dest]) {
                    minHeap.add(it);
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int nodes = 5;
        List<List<Edge>> adj = new ArrayList<>(nodes);

        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Edge(1, 6));
        adj.get(0).add(new Edge(3, 4));
        adj.get(1).add(new Edge(2, 10));
        adj.get(1).add(new Edge(3, 7));
        adj.get(1).add(new Edge(4, 7));
        adj.get(2).add(new Edge(3, 8));
        adj.get(2).add(new Edge(4, 5));
        adj.get(3).add(new Edge(4, 12));

        int minCost = mst(nodes, adj, 0);
        System.out.println("Cost of MST: " + minCost);
    }
}
