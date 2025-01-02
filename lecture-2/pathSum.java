
public class pathSum {

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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }

    public static boolean solve(TreeNode root, int target, int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return target - root.val == 0;
        }

        return solve(root.left, target - root.val, sum) || solve(root.right, target - root.val, sum);
    }
}
