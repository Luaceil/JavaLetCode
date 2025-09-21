import java.util.*;

class  TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val ){ this.val = val;}
}
public class Main {

    public static void main(String[] args) {
        AbstractMap.SimpleEntry<Integer,Integer> a=new AbstractMap.SimpleEntry<Integer, Integer>(1,2);
        ThreadLocal<Integer> threadLocal  = new ThreadLocal<>();
        ThreadLocal<Boolean> threadLocal2  = new ThreadLocal<>();
        threadLocal.set(11);
        threadLocal2.set(true);
        lastGet(new TreeNode(1));

    }

  static   void lastGet(TreeNode root){
        if(root == null ) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        Set<TreeNode> set = new HashSet<>();
        while(!st.empty()){
            TreeNode cur = st.peek();
            if(((cur.left==null)||set.contains(cur.left))&&(cur.right==null||set.contains(cur.right))){
                //出操作
                st.pop();
            }else {
                //入操作
                if(cur.right!=null){st.push(cur.right);set.add(cur.right);}
                if(cur.left!=null){st.push(cur.left);set.add(cur.left);}
            }
        }
    }
}
