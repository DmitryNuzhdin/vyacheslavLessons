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
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            current = nodeQueue.poll();
            TreeNode tmpLeft = current.right;
            current.right = current.left;
            current.left = tmpLeft;
            if (current.left != null)
                nodeQueue.add(current.left);
            if (current.right != null)
                nodeQueue.add(current.right);
        }
        return root;
    }

    public static void printTree(TreeNode _node)
    {
        StringBuilder strTree = new StringBuilder();
        strTree.append(_node.val);
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(_node);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            if (current.left != null){
                nodeQueue.add(current.left);
                strTree.append(" ").append(current.left.val);
            }
            else
                strTree.append(" null");
            if(current.right != null){
                nodeQueue.add(current.right);
                strTree.append(" ").append(current.right.val);
            }
            else
                strTree.append(" null");
        }
        System.out.println(strTree);
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
        System.out.println("ROOT1 BEFORE");
        printTree(root1);
        System.out.println("ROOT2 BEFORE");
        printTree(root2);

        TreeNode res1 = invertTree(root1);
        System.out.println("\nINVERTING ROOT1");
        printTree(root1);
        System.out.println("\nINVERTING RES1");
        printTree(res1);

        TreeNode res2 = invertTree2(root2);
        System.out.println("\nINVERTING ROOT2");
        printTree(root2);
        System.out.println("\nINVERTING RES2");
        printTree(res2);
    }
}