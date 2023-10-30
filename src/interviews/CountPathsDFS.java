package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Q. Given a egress array (i.e. array with no. of outgoing edges from a node) of a directed graph,
    count no. of unique edges from each node to the given destination node
    Note:
      1. node n and m can only have an edge between them if there's edge to n+1, n+2, ..., m-1 from n.
      2. graph don't have self loops or multiple edges between same 2 nodes

      Example:
        Input: [2, 0, 2, 1, 1, 0], destination = 4
        Output: 5
        Explanation: node 0 has 2 outgoing edges so as per edge formation condition, these 2 outgoing edges
            should be only to node 1, and node 2. similarly the adjacency list becomes -

            0 - 1, 2
            1 - null
            2 - 3, 4
            3 - 4
            4 - 5
            5 - null

            Hence, all the paths are -
               1) 0 - 2 - 3 - 4     2) 0 - 2 - 4    3) 2 - 3 -4     4) 2 - 4    5) 3 - 4

 */
public class CountPathsDFS {
    // T.C. - O(N2) worst case since memoization used to
    // not to re-run dfs for intermediate nodes already traversed in found paths.
    static int solution(List<List<Integer>> adjList, int N, int dest) {
        int[] memo = new int[N];
        Arrays.fill(memo, -1);

        int ans = 0;
        for (int i = 0; i < dest; i++) {
            for (int node : adjList.get(i)) {
                ans += dfs(adjList, node, dest, memo);
            }
        }

        return ans;
    }

    static int dfs(List<List<Integer>> adjList, int currNode, int dest, int[] memo) {
        // base case
        if (currNode == dest) return 1;

        if (memo[currNode] != -1) return memo[currNode];

        int count = 0;
        for (int neighNode : adjList.get(currNode)) {
            count += dfs(adjList, neighNode, dest, memo);
        }

        memo[currNode] = count;

        return count;
    }

    static List<List<Integer>> fillAdjList(int[] egress) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < egress.length; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add(1);
        list.get(0).add(2);
        list.get(2).add(3);
        list.get(2).add(4);
        list.get(3).add(4);
        list.get(4).add(5);

        return list;
    }

    public static void main(String[] args) {
        int[] egress = {2, 0, 2, 1, 1, 0};
        List<List<Integer>> adjList = fillAdjList(egress);
        System.out.println(solution(adjList, 6, 4));
    }
}
