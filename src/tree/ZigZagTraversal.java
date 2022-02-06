package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void traverse(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true; // boolean flag to know current direction of traversal

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (!leftToRight) {
                    row.add(0, node.data);
                } else {
                    row.add(node.data);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // After current level done
            leftToRight = !leftToRight;

            // Printing
            for (Integer ele: row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);

        traverse(root);
    }
}
