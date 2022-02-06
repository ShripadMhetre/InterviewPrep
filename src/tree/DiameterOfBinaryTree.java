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
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);


    }
}
