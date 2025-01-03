public class flipEquivalent {
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
        
    public static boolean solve(TreeNode root1, TreeNode root2){
            if(root1 == null && root2 == null){
                return true;
            }
            if(root1 == null || root2 == null){
                return false;
            }
            if(root1.val != root2.val){
                return false;
            }
    
            boolean flip = solve(root1.left,root2.right) && solve(root1.right,root2.left);
    
            boolean not_flip = solve(root1.left,root2.left) && solve(root1.right,root2.right);
    
            return flip || not_flip;
        }
    }

