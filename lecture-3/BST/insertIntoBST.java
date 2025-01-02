
public class insertIntoBST {
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

    public TreeNode insert(TreeNode root, int val) {
        if(root == null){
            return new TreeNode();
        }
         if(root.val < val){
            root.right = insert(root.right, val);
         }else{
            root.left = insert(root.left, val);
         }
         return root;
    }
}
