package tree;

public class CheckTwoTreeIdentical {

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null || root2 == null) return root1 == root2;

        boolean isLeftIdentical = isIdentical(root1.left, root2.left);
        boolean isRightIdentical = isIdentical(root1.right, root2.right);

        return (root1.data == root2.data) && isLeftIdentical && isRightIdentical;
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(12);
        root1.right = new Node(8);
        root1.left.right = new Node(1);
        root1.right.left = new Node(3);

        Node root2 = new Node(10);
        root2.left = new Node(12);
        root2.right = new Node(8);
        root2.left.right = new Node(1);
        root2.right.left = new Node(3);

        boolean res = isIdentical(root1, root2);
        System.out.println("is identical: " + res);
    }
}
