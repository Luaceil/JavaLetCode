package treeLength;
import java.util.*;



public class Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            arr.add(sc.nextInt());
        }
        TreeNode root = arrToTree(arr);
        //System.out.println(root.left.val+" "+root.right.val);
        dfsFirst(root);
    }

    public static TreeNode arrToTree(ArrayList<Integer> arr) {
        if (arr.isEmpty()) return null;
        TreeNode root = new TreeNode(arr.get(0));
        ArrayDeque<TreeNode> faNode = new ArrayDeque<>();
        faNode.addLast(root);
        int i = 1;
        boolean lrFlag = false;
        while (!(faNode.isEmpty()) && i < arr.size()) {
            TreeNode node = faNode.peekFirst();
            if (lrFlag) {
                node.right = new TreeNode(arr.get(i));
                faNode.addLast(node.right);
                faNode.removeFirst();
            } else {
                node.left = new TreeNode(arr.get(i));
                faNode.addLast(node.left);
            }
            lrFlag = !lrFlag;
            i++;
        }
        return root;
    }

    private static void dfsFirst(TreeNode root) {
        if (root == null) return;
        //先序遍历
        System.out.print(root.val + " ");
        dfsFirst(root.left);
        dfsFirst(root.right);
    }

    private static class MaxMinPair {
        int max;
        int min;

        MaxMinPair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    private static MaxMinPair dfsMAXMIN(TreeNode root, int max, int min) {
        if (root == null) return new MaxMinPair(max, min);
        //先序遍历
        max = root.val > max ? root.val : max;
        min = root.val < min ? root.val : min;
        MaxMinPair pair = dfsMAXMIN(root.left, max, min);
        max = pair.max;
        min = pair.min;
        return dfsMAXMIN(root.right, max, min);
    }

    private static int getLength(TreeNode root) {
        int valMax = Integer.MIN_VALUE;
        int valMin = Integer.MAX_VALUE;
        MaxMinPair pair = dfsMAXMIN(root, valMax, valMin);
        valMax = pair.max;
        valMin = pair.min;
        Tree.lca(root, valMax, valMin);
        int result = 0;
        return result;
    }

    static boolean minGet = false;

    private static TreeNode lca(TreeNode root, int max, int min) {
        return root;
    }
}
