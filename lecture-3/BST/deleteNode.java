import java.util.*;
public class deleteNode {
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
// TIME COMPLEXITY ---> O(n)
    public static TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(key > root.val){
            root.right = delete(root.right, key);
        }else if(key < root.val){
            root.left = delete(root.left, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                int max = max(root.left);
                root.left = delete(root.left, max);
                root.val = max;
            }
        }
        return root;
    }

    public static int max(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int rmax = max(root.right);
        return Math.max(root.val, rmax);
    }
}
