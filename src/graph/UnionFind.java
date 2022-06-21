package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionFind {
    // Returns the parent of given node
    public static int find(int node, int[] parent) {
        int res = node;

        while (res != parent[res]) {
            parent[res] = parent[parent[res]];
            res = parent[res];
        }

        return res;
    }

    // Returns true if it could do union of nodes, otherwise false
    public static boolean union(int node1, int node2, int[] parent, int[] rank) {
        int p1 = find(node1, parent);
        int p2 = find(node2, parent);

        // parent already same hence union won't be done again.
        if (p1 == p2) return false;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        // return true as we successfully performed the union
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int[] edge: edges) {
            if (!union(edge[0], edge[1], parent, rank)) {
                System.out.println("False: " + edge[0] + " -> " + edge[1]);
            } else {
                System.out.println("True: " + edge[0] + " -> " + edge[1]);
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println("Parent of " + i + ": " + parent[i]);
        }
    }
}
