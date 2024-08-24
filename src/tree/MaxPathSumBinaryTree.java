package tree;

public class MaxPathSumBinaryTree {
    // T.C. -> O(), S.C. -> O() uses postorder traversal
    public static int solution(Node root, int[] maxSum) {
        if (root == null) return 0;

        int leftSum = Math.max(0,solution(root.left, maxSum));
        int rightSum = Math.max(0, solution(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], root.data + leftSum + rightSum);

        return root.data + Math.max(leftSum, rightSum);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);

        int[] maxSum = new int[1];

        solution(root, maxSum);

        System.out.println("Max Path Sum: " + maxSum[0]);
    }
}
