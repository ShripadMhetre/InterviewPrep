package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    /**
     * Breadth First/ Level Order Traversal:
     */
    public static void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
    }

    /**
     * Depth First Traversal:
     *      1. Preorder
     *      2. Inorder
     *      3. Postorder
     */

    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    // Iterative Preorder Traversal
    public static void iterativePreorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);   // Push root node into the stack

        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.data + " ");
            /*
                Preorder is Node Left Right
                Stack is Last in first out (LIFO) Hence we push right node first and then left
                So that left Node first popped.
             */
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Iterative inorder Traversal
    public static void iterativeInorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node node = root;

        /*
            Inorder is Left Node Right
            We keep pushing nodes into stack as long as left node is not null,
            If found null then pop the current node and go to right node.
            once stack empty break out of loop.
         */
        while(true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;

                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

    public static void postorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative Post Order Traversal
    public static void iterativePostorder(Node root) {

    }

    /**
     * Maximum Height/Depth of a Binary Tree:-
     *      Maximum Depth is the count of nodes of the longest path from the root node to the leaf node.
     */
    public static int maxHeight(Node root) {
        if (root == null) return 0;

        // Calculating max height of left and right subtree recursively
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        // answer = max height out of left & right subtree + 1 (i.e. for current root)
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);

//        inorder(root);
//        preorder(root);
//        postorder(root);

        BFS(root);
    }
}
