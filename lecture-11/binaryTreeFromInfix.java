public class binaryTreeFromInfix{
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
    
    public TreeNode expTree(String s){
        s = getPostfix(s);
        Stack<Node> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                st.push(new Node(ch));
            }else{
                Node right = st.pop();
                Node left = st.pop();
                Node neww = new Node(ch);
                neww.left = left;
                neww.right = right;
                st.push(neww);
            }
        }
        return st.peek();
    }

    public String getPostfix(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                sb.append(ch);
            }else if(ch == '('){
                sb.append(ch);
            }else if(ch == ')'){
                while(st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();   //open bracket pop
            }else{
                while(!st.isEmpty() && precedence(st.peek()) >= precedence(ch)){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        return sb.toString();
    }

    public int precedence(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return -1;
        }
    }
}

















