public class HeightOfTree {

    public int idx = -1;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode buildTree(int nodes[]){
        idx++;
        if(idx >= nodes.length || nodes[idx] == -1){
            return null;
        }

        TreeNode newNode = new TreeNode(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int treeHeight = Math.max(leftHeight, rightHeight) + 1;

        return treeHeight;
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        HeightOfTree t = new HeightOfTree();

        TreeNode root = t.buildTree(nodes);
        System.out.println(t.heightOfTree(root));
    }
}
