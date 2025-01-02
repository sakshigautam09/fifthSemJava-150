
public class validateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // we created class here, because we need to check min, max and isBST associated with every node
    class BSTpair{
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        boolean isbst = true;
    }

    public boolean isValidBST(TreeNode root) {
        return validBST(root).isbst;
    }
    public BSTpair validBST(TreeNode root){
        if(root == null){
            return new BSTpair();
        }
        // lbp -> left bst pair
        // rbp -> right bst pair
        // sbp -> self bst pair
        BSTpair lbp = validBST(root.left);
        BSTpair rbp = validBST(root.right);
        BSTpair sbp = new BSTpair();
        sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
        sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
        sbp.isbst = lbp.isbst && rbp.isbst && root.val > lbp.max && root.val < rbp.min;

        return sbp;
    }
}
