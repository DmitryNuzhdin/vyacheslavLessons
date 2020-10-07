package leetcode.invertBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        TreeNode current;
        if (root == null)
            return null;
        TreeNode invertTree = root;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(invertTree);
        while (!nodeQueue.isEmpty()) {
            current = nodeQueue.poll();
            TreeNode tmpLeft = current.left;
            current.right = current.left;
            current.left = tmpLeft;
            if (current.left != null)
                nodeQueue.add(current.left);
            if (current.right != null)
                nodeQueue.add(current.right);
        }
        return invertTree;
    }

    public static void printTree(TreeNode _node)
    {
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(_node);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            System.out.println(current.val);
            if (current != null) {
                nodeQueue.add(current.left);
                nodeQueue.add(current.right);
            }
        }
    }
    public static void main(String[] args){
        TreeNode root1, root2;
        TreeNode l1;
        TreeNode r1;

        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);

        r1 = new TreeNode(3);
        l1 = new TreeNode(2, l2, r2);
        root1 = new TreeNode(1, l1, r1);
        root2 = new TreeNode(1, l1, r1);
        TreeNode res1 = invertTree(root1);
        TreeNode res2 = invertTree2(root2);
        printTree(res1);
        printTree(res2);
    }
}