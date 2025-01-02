import java.util.ArrayList;
import java.util.List;

public class binaryRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, 1, ans);
        return ans;
    }

    static int maxdepth = 0;
    public static void solve(TreeNode root, int curr_level, List<Integer> ans){
        if(root == null){
            return;
        }

        if(curr_level > maxdepth){
            ans.add(root.val);
            maxdepth = curr_level;
        }

        solve(root.right, curr_level + 1, ans);
        solve(root.left, curr_level + 1, ans);
    }
}
