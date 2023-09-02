package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int dest;
    int weight;

    public Edge (int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

/*
    Dijkstra's Algorithm :-
        - Single Source Shortest Path Algorithm
        - Works for directed, undirected and also graph with cycles
        - Algorithm won't work for negetive weights
 */
public class DijkstraAlgorithm {
    private static int dijkstra(int nodes, List<List<Edge>> adj, int source, int destination) {
        int[] distance = new int[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[nodes];

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

        distance[source] = 0;
        minHeap.add(new Edge(source, 0));

        while (!minHeap.isEmpty()) {
            int v = minHeap.poll().dest;

            if (visited[v]) continue;

            visited[v] = true;

            for (Edge it: adj.get(v)) {
                int dist = it.weight;
                int node = it.dest;

                if (!visited[node] && (distance[v] + dist < distance[node])) {
                    distance[node] = distance[v] + dist;
                    it.weight = distance[v] + dist;
                    minHeap.add(it);
                }
            }
        }
        return distance[destination];
    }

    public static void main(String[] args) {
        int nodes = 5;
        List<List<Edge>> adj = new ArrayList<>(nodes);

        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

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

        int ans1 = dijkstra(nodes, adj, 0, 4);
        System.out.println("Shortest Distance between source and destination: " + ans1);

    }
}
