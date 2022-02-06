package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraph {
    /*
        Solution:-
            Bipartite graph if graph can be coloured with only 2 colors such that
            no two adjacent nodes have same color.

            Note - If graph contains cycle with odd no. of nodes then not bipartite.
     */
    public static boolean isBipartiteDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // array to store the color of nodes. Colors initialized to -1.
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // looping over all the nodes in case of disconnected graph
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(adj, i, color)) return false;
            }
        }

        // If the loop doesn't return false for any of the node then finally return true.
        return true;
    }

    public static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
        // If node being visited for the first time, then set its color to 1.
        if (color[node] == -1) color[node] = 1;

        // loop over adjacent nodes
        for (int it: adj.get(node)) {
            // if adjacent node being visited for first time time set its color to opposite of current node
            // i.e. 1 - color[node] returns 0 or 1 based on current nodes color is 1 or 0 respectively
            if (color[it] == -1) {
                color[it] = 1 - color[node];
            } else if (color[it] == color[node]) {
                // if adjacent node visited and color is same as parent then not a bipartite graph
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>(Arrays.asList(3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));

        System.out.println("is Bipartite: " + isBipartiteDFS(V, adj));
    }
}
