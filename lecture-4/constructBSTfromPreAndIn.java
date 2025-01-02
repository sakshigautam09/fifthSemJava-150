
public class constructBSTfromPreAndIn {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode createTree(int[] pre, int[] in, int plow, int phigh, int ilow, int ihigh) {
        if(plow > phigh || ilow > ihigh){
            return null;
        }
        TreeNode node = new TreeNode(pre[plow]);
        int idx = search(in, ilow, ihigh, pre[plow]);
        int l = idx - ilow;
        node.left = createTree(pre, in, plow + 1, plow + l, ilow, idx-1);
        node.right = createTree(pre, in, plow + l + 1, phigh, idx+1, ihigh);

        return node;
    }

    public int search(int[] in, int low, int high, int item){
        for(int i = low; i <= high; i++){
            if(in[i] == item){
                return i;
            }
        }
        return 0;
    }
}

















