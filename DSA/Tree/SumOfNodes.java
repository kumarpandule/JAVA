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

    public int getSum(TreeNode root, boolean isLeftLeave){
        if(root.left == null && root.right == null){
            return isLeftLeave ? root.val : 0; 
        }

        int sum = 0;
        if(root.left != null){
            sum += getSum(root.left, true);
        }
        if(root.right != null){
            sum += getSum(root, false);
        }

        return sum;
    }

    public int sumOfNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        return getSum(root, false);
    }

    public static void main(String args[]){
        SumOfNodes t = new SumOfNodes();
        int nodes[] = {3,9,20,-1,-1,15,7};

        TreeNode root = t.buildTree(nodes);
        System.out.println(t.sumOfNodes(root));

    }
}