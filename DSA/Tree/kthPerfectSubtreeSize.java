import java.util.*;

public class kthPerfectSubtreeSize {

    public int idx = -1;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int nodes[]) {
        idx++;
        if (nodes.length <= idx || nodes[idx] == -1) {
            return null;
        }

        TreeNode newNode = new TreeNode(nodes[idx]);
        System.out.print(newNode.val + " ");
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> sizes = new ArrayList<>();
        findPerfectSubtrees(root, sizes);
        Collections.sort(sizes, Collections.reverseOrder());
        return k <= sizes.size() ? sizes.get(k - 1) : -1;
    }

    private int findPerfectSubtrees(TreeNode node, List<Integer> sizes) {
        if (node == null)
            return 0;
        int leftSize = findPerfectSubtrees(node.left, sizes);
        int rightSize = findPerfectSubtrees(node.right, sizes);
        if (leftSize == rightSize && (leftSize == 0 || node.left != null && node.right != null)) {
            int size = leftSize + rightSize + 1;
            sizes.add(size);
            return size;
        }
        return -1;
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1 };
        kthPerfectSubtreeSize t = new kthPerfectSubtreeSize();
        TreeNode root = t.buildTree(nodes);
        int k = 1;
        int result = t.kthLargestPerfectSubtree(root, k);
        System.out.println("The size of the " + k + "th largest perfect binary subtree is: " + result);
    }
}
