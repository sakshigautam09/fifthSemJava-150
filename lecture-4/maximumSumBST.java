
public class maximumSumBST {
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

    class BSTpair{
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        boolean isbst = true;
        int sum = 0;   //current tree's sum
        int ans = 0;  //maximum sum in current BST
    }

    public int maxSumBST(TreeNode root) {
        return validBST(root).ans;
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
        sbp.min = Math.min(lbp.min, Math.max(rbp.min, root.val));
        sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
        sbp.sum = lbp.sum + rbp.sum + root.val;
        sbp.isbst = lbp.isbst && rbp.isbst && root.val > lbp.max && root.val < rbp.min;
        if(sbp.isbst){
            sbp.ans = Math.max(lbp.ans, Math.max(rbp.ans, sbp.sum));
        }else{
            sbp.ans = Math.max(lbp.ans, rbp.ans);
        }

        return sbp;
    }
}
