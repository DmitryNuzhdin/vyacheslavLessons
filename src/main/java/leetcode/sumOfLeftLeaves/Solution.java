package leetcode.sumOfLeftLeaves;

import java.util.Stack;

public class Solution {
    public static int sumOfLeftLeaves(TreeNode root){
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    public static int sumSecondVersion(TreeNode root)
    {
        int sum = 0;
        boolean isLeft = false;
        Stack<TreeNode> stackTree = new Stack<>();
        TreeNode current = root;
        while(current != null || stackTree.size()>0){
            while (current != null) {
                stackTree.push(current);
                if (current.left == null && current.right == null && isLeft)
                    sum += current.val;
                current = current.left;
                isLeft = true;
            }
            current = stackTree.pop();
            current = current.right;
            isLeft = false;
        }
        return sum;
    }
    public static void main(String[] args){
        TreeNode root;
        TreeNode l1;
        TreeNode r1;

        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);

        r1 = new TreeNode(3);
        l1 = new TreeNode(2, l2, r2);
        root = new TreeNode(1, l1, r1);





        int res1 = sumOfLeftLeaves(root);
        int res2 = sumSecondVersion(root);
        System.out.println("First check");
        System.out.println(res1);
        System.out.println(res2);

        res1 = sumOfLeftLeaves(l1);
        res2 = sumSecondVersion(l1);
        System.out.println("Second check");
        System.out.println(res1);
        System.out.println(res2);
    }
}
