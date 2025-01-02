public class pathSum3 {
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

    int ans = 0;
    public static int pathSum(TreeNode root, int targetSum){
        return path(root, targetSum);
    }
    public static int path(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }
        int c = countpath(root, targetSum);
        int l = countpath(root.left, targetSum);
        int r = countpath(root.right, targetSum);

        return c + l + r;
    }

    public static int countpath(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }

        int count = 0;

        if(root.val - targetSum == 0){
            count++;
        }

        int left = countpath(root.left, targetSum - root.val);
        int right = countpath(root.right, targetSum - root.val);

        return left + right + count;
    }
}
