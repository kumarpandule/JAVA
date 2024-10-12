
public class BinaryTree {

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
        if(nodes.length <= idx ||nodes[idx] == -1){
            return null;
        }
        
        TreeNode newNode = new TreeNode(nodes[idx]);
        System.out.print(newNode.val + " ");
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        BinaryTree b = new BinaryTree();
        TreeNode root = b.buildTree(nodes);
    }
}
