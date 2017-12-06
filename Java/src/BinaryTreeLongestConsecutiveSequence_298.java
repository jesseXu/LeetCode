class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class BinaryTreeLongestConsecutiveSequence_298 {

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0; // this is edge case!!!
        return dfs(root, 1);
    }

    public int dfs(TreeNode node, int n) {
        int left = node.left != null ? dfs(node.left, node.left.val - 1 == node.val ? n + 1 : 1)  : n;
        int right = node.right != null ? dfs(node.right, node.right.val - 1 == node.val ? n + 1 : 1) : n;
        return Math.max(Math.max(left, right), n);
    }
}
