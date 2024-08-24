package graph;

import java.util.*;

/*
    Q. Given a connected graph, find the minimum number of colors required to color all the nodes, such that no
    adjacent vertices have the same color.
 */
public class GraphColoring {
    static class Edge {
        int dest;
        int weight;

        public Edge (int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // T.C. -> O(V + E), S.C. -> O(V)
    public static Map<Integer, Integer> colorGraph(int nodes, List<List<Edge>> graph) {
        Map<Integer, Integer> colorMap = new HashMap<>();

        // Iterate over each vertex
        for (int vertex = 0; vertex < nodes; vertex++) {
            // Find all neighboring colors
            Set<Integer> neighborColors = new HashSet<>();

            for (Edge it : graph.get(vertex))
                if (colorMap.containsKey(it.dest))
                    neighborColors.add(colorMap.get(it.dest));

            // Find the color number that is not used by the neighbors
            int color = 1;
            while (neighborColors.contains(color))
                color++;

            colorMap.put(vertex, color);
        }

        return colorMap;
    }

    public static void main(String[] args) {
        // Creating a graph that has 6 vertices
        //          4
        //   0--------       -----------3-------
        //   |        \     / 3                 \ 2
        //   |         \   /           6         \
        //   | 4         2 ---------------------- 4
        //   |         /   \                     /
        //   |        /     \ 1                 / 3
        //   1--------       ---------5---------
        //          2
        int nodes = 6;
        List<List<Edge>> graph = new ArrayList<>(6);
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(3, 3));
        graph.get(2).add(new Edge(4, 6));
        graph.get(2).add(new Edge(5, 1));
        graph.get(3).add(new Edge(4, 2));
        graph.get(5).add(new Edge(4, 3));

        Map<Integer, Integer> colorMap = colorGraph(nodes, graph);

        System.out.println("Node colors:");

        int maxColorValue = -1;
        for (Map.Entry<Integer, Integer> entry : colorMap.entrySet()) {
            maxColorValue = Math.max(maxColorValue, entry.getValue());
            System.out.println("Node " + entry.getKey() + " -> Color " + entry.getValue());
        }
        System.out.println("Minimum number of colors used: " + maxColorValue);
    }
}
