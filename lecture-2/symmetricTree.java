public class symmetricTree{  
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return solve(root.left, root.right);
    }
    public static boolean solve(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        
        boolean l = solve(left.left, right.right);
        if(!l){
            return false;
        }
        boolean r = solve(left.right, right.left);
        
        return r;
    }
}