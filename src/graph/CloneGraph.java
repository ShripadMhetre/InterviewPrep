package graph;

import java.util.*;

/*
    Q. Given a reference of a node in a connected undirected graph.
        Return a deep copy (clone) of the graph.

        Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

        Test case format:
        For simplicity, each node's value is the same as the node's index (1-indexed).
        For example, the first node with val == 1, the second node with val == 2, and so on.
        The graph is represented in the test case using an adjacency list.

        An adjacency list is a collection of unordered lists used to represent a finite graph.
        Each list describes the set of neighbors of a node in the graph.

        The given node will always be the first node with val = 1. You must return the copy of the given node
        as a reference to the cloned graph.
 */
public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneDFS(Node source) {
        HashMap<Node, Node> oldToNew = new HashMap<>();
        return dfsUtil(source, oldToNew);
    }

    public static Node dfsUtil(Node node, HashMap oldToNew) {
        if (node == null) return null;
        if (oldToNew.containsKey(node)) return (Node) oldToNew.get(node);

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node nei: node.neighbors) {
            copy.neighbors.add(dfsUtil(nei, oldToNew));
        }

        return copy;
    }

    public static void printDFS(Node node, Set<Node> visited) {
        visited.add(node);

        System.out.print(node.val + " ");

        for (Node nei: node.neighbors) {
            if (!visited.contains(nei)) printDFS(nei, visited);
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        two.neighbors.add(one);

        one.neighbors.add(three);
        three.neighbors.add(one);

        two.neighbors.add(four);
        four.neighbors.add(two);

        one.neighbors.add(three);
        three.neighbors.add(one);

        Node cloneOne = cloneDFS(one);

        //print cloned
        Set<Node> visited = new HashSet<>();
        printDFS(cloneOne, visited);
    }
}
