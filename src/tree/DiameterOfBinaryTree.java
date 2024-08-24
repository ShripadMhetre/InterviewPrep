package tree;

/*
    Diameter of Binary Tree :-
        1. longest path between 2 nodes
        2. Path does not need to pass via root

        Naive Solution - O(N2)
            We find left and right height for each node
            The longest path will be Max(lh + rh)

         Optimal - O(N)

 */
public class DiameterOfBinaryTree {
    public static int solution(Node root) {
        int[] diameter = new int[1];
        dfsUtil(root, diameter);
        return diameter[0];
    }

    private static int dfsUtil(Node root, int[] diameter) {
        if (root == null) return 0;

        int lh = dfsUtil(root.left, diameter);
        int rh = dfsUtil(root.right, diameter);

        System.out.println("lh: " + lh + " & rh: " + rh);
        diameter[0] = Math.max(diameter[0], lh + rh);

        System.out.println("ans: " + diameter[0]);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Diameter: " + solution(root));
    }
}
