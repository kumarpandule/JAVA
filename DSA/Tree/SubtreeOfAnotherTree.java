public class SubtreeOfAnotherTree {

    public int idx = -1;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
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

    public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }

        if(root.val == subRoot.val){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }

        if(root.val == subRoot.val){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String args[]){
        SubtreeOfAnotherTree t = new SubtreeOfAnotherTree();
        int tree[] = {9,7,8,-1,-1,1,2,-1,-1,3,-1,-1,4,5,-1,-1,6,-1};
        int subTree[] = {1,2,-1,-1,3,-1};

        TreeNode root = t.buildTree(tree);
        TreeNode subRoot = t.buildTree(subTree);

        System.out.println(t.isSubtree(root, subRoot));
    }
}
