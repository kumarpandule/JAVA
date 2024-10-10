public class SumOfLeftLeaves {

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

    public int getSum(TreeNode root, boolean isLeftLeafe){
        if(root.left == null && root.right == null){
            System.out.print(root.val + " ");
            return (isLeftLeafe) ? root.val : 0;
        }
        int sum = 0;
        if(root.left != null){
            sum += getSum(root.left, true);
        }
        if(root.right != null){
            sum += getSum(root.right, false);
        }

        return sum;
    }

    public int sumOfLeftLeave(TreeNode root){
        if(root == null){
            return 0;
        }

        return getSum(root, false);
    }

    public static void main(String args[]){
        int nodes[] = {3,9,20,-1,-1,15,7};
        SumOfLeftLeaves t = new SumOfLeftLeaves();

        TreeNode root = t.buildTree(nodes);
        System.out.println(t.sumOfLeftLeave(root));
    }
}
