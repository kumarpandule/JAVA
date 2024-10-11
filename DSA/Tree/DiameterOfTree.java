public class DiameterOfTree {

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

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public int diameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int maxDiameter = height(root.left) + height(root.right) + 1;
        return Math.max(maxDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // Optimized way to calculate diameter of a tree
    public class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public TreeInfo diameter2(TreeNode root){
        if(root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int leftdiameter = left.diameter;
        int rightDiameter = right.diameter;
        int diameter = left.height + right.height + 1;

        int maxDiameter = Math.max(Math.max(leftdiameter, rightDiameter), diameter);

        TreeInfo info = new TreeInfo(height, maxDiameter);
        return info;
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};

        DiameterOfTree t = new DiameterOfTree();

        TreeNode root = t.buildTree(nodes);
        System.out.println(t.diameter(root));
        System.out.println(t.diameter2(root).diameter);
    }
}
