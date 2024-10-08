
public class SumOfNodes {

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
        if(nodes.length <= idx || nodes[idx] == -1){
            return null;
        }

        TreeNode newNode = new TreeNode(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public int sumOfNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftLeave  = sumOfNodes(root.left);
        int rightLeave = sumOfNodes(root.right);

        return leftLeave + rightLeave + root.val;
    }

    public static void main(String args[]){
        SumOfNodes t = new SumOfNodes();
        int nodes[] = {3,9,-1,-1,20,15,-1,-1,7,-1};

        TreeNode root = t.buildTree(nodes);
        System.out.println(t.sumOfNodes(root));

    }
}