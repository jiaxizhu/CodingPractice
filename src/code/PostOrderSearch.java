package code;

import java.util.*;

/**
 * @author zhujiaxi01
 * @date 2022-11-14 15:12
 */
public class PostOrderSearch {
    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {




    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            res.add(cur.value);
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
    public static List<Integer> postorderTraversal(TreeNode root) {

    }
}

