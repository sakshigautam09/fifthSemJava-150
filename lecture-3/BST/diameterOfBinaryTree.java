import java.util.*;
public class diameterOfBinaryTree{
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

    public int diameterOfBinaryTree(TreeNode root) {
        // return diameter(root);
        return diameter(root).d;
    }

    // OPTIMIZED  (O(n))
    class diaPair{
        int d = 0;
        int ht = -1;

    }

    public diaPair diameter(TreeNode root) {
        if (root == null) {
            diaPair base = new diaPair();
            base.ht = -1;
            base.d = 0;
            return base;
        }
        diaPair left_diaPair = diameter(root.left);
        diaPair right_diaPair = diameter(root.right);
        diaPair self_diaPair = new diaPair();
        self_diaPair.ht = Math.max(left_diaPair.ht, right_diaPair.ht) + 1;
        int self_diameter = left_diaPair.ht + right_diaPair.ht + 2;

        self_diaPair.d = Math.max(self_diameter, Math.max(left_diaPair.d, right_diaPair.d));

        return self_diaPair;
    }


// -----------------------------------------O(n^2)-----------------------
    // public static int diameter(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }
    //     int left_diameter = diameter(root.left);
    //     int right_diameter = diameter(root.right);
    //     int start_diameter = height(root.left) + height(root.right) + 2;

    //     return Math.max(start_diameter, Math.max(left_diameter, right_diameter));
    // }

    // public static int height(TreeNode root){
    //     if(root == null){
    //         return -1;
    //     }
    //     int l = height(root.left);
    //     int r = height(root.right);
    //     return Math.max(l, r);
    // }
}