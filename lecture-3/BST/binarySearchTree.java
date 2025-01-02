public class binarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    private TreeNode root;
    public binarySearchTree(int[] in){
        root = createTree(in, 0, in.length-1);
    }

    private TreeNode createTree(int[] in, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode();
        n.val = in[mid];
        n.left = createTree(in, start, mid - 1);
        n.right = createTree(in, mid + 1, end);

        return n;
    }
}
