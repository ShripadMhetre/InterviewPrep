package tree;

/*
    Q. You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree
        were swapped by mistake. Recover the tree without changing its structure.
 */
public class RecoverBST {
    Node prev = null, small = null, big = null;

    public void recoverTree(Node root) {
        if (root == null) return;

        inorder(root);
        int tmp = small.data;
        small.data = big.data;
        big.data = tmp;
    }

    private void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null && prev.data > node.data) {
            if (small == null) small = prev;
            big = node;
        }
        prev = node;

        inorder(node.right);
    }
}
