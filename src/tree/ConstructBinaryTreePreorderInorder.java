package tree;

import java.util.HashMap;

public class ConstructBinaryTreePreorderInorder {
    public static Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return builder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    private static Node builder(int[] preorder, int preStart, int preEnd,
                             int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);

        int inIdx = inMap.get(root.data);
        int leftNodes = inIdx - inStart;

        root.left = builder(preorder, preStart+1, preStart+leftNodes,
                inorder, inStart, inIdx-1, inMap);
        root.right = builder(preorder, preStart+leftNodes+1, preEnd,
                inorder, inIdx+1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3,4};
        int[] inorder = {2,1,3,4};

        Node root = buildTree(preorder, inorder);
        inorder(root);
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
