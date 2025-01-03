public class sumRootToLeafNumbers{
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
    public static int sumNumbers(TreeNode root){
        return solve(root, 0);
    }
    public static int solve(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null){
            return sum;
        }

        int left = solve(root.left, sum);
        int right = solve(root.right, sum);

        return left + right;
    }
}