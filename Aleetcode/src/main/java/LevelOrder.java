package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

     TreeNode root;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size != 0) {
                TreeNode node = queue.poll();
                level.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;

            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
    }
}
