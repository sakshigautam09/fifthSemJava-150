import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class binaryTree{
    class Node{
        int val;
        Node left;
        Node right;
    }
    private Node root;  //it is private, so that any user from outside can not change anything inside file

    // constructor -> to create tree
    public binaryTree(){
        root = createTree();
    }

    Scanner sc = new Scanner(System.in);
    private Node createTree(){
        int item = sc.nextInt();
        Node n = new Node();
        n.val = item;

        boolean hasLeftChild = sc.nextBoolean();
        if(hasLeftChild){
            n.left = createTree();
        }

        boolean hasRightChild = sc.nextBoolean();
        if(hasRightChild){
            n.right = createTree();
        }
        return n;
    }

    private void display(Node n){
        if(n == null){
            return;
        }
        String s = "";
        s = "<--" + n.val + "-->";

        if(n.left != null){
            s = n.left.val + s;
        }else{
            s = "." + s;
        }

        if(n.right != null){
            s = s + n.right.val;
        }else{
            s = s + ".";
        }

        System.out.println(s);
        display(n.left);
        display(n.right);
    }

    public void display2(){
        display(root);
    }

    private int max(Node n){
        if(n == null){
            return Integer.MIN_VALUE;
        }
        int left = max(n.left);
        int right = max(n.right);
        return Math.max(left, Math.max(right, n.val));
    }

    public int max2(){
        return max(root);
    }

    public boolean find2(int item){
        return find(root, item);
    }

    private boolean find(Node n, int item){
        if(n == null){
            return false;
        }
        if(n.val == item){
            return true;
        }
        boolean left = find(n.left, item);
        boolean right = find(n.right, item);

        return left || right;
    }

    public int maxHeight2(){
        return maxHeight(root);
    }

    private int maxHeight(Node n){
        if(n == null){
            return -1;
        }
        int leftHeight = maxHeight(n.left);
        int rightHeight = maxHeight(n.right);
        return Math.max(leftHeight, rightHeight) + 1;  //have done +1 because of root
    }

    public void preOrder2(){
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node n){
        // input format is the PREORDER traversal
        if(n == null){
            return;
        }
        System.out.print(n.val + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public void inOrder2(){
        preOrder(root);
        System.out.println();
    }
    
    private void inOrder(Node n){
        // input format is the PREORDER traversal
        if(n == null){
            return;
        }
        preOrder(n.left);
        System.out.print(n.val + " ");
        preOrder(n.right);
    }

    public void postOrder2(){
        preOrder(root);
        System.out.println();
    }

    private void postOrder(Node n){
        // input format is the PREORDER traversal
        if(n == null){
            return;
        }
        preOrder(n.left);
        preOrder(n.right);
        System.out.print(n.val + " ");
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node top = q.poll();
            System.out.print(top.val + " ");

            if(top.left != null){
                q.add(top.left);
            }
            if(top.right != null){
                q.add(top.right);
            }
        }
        System.out.println();
    }
}