public class BinarySearchTree {

    static int count = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    
    static TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(root.val > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    static TreeNode kthSmallest(TreeNode root, int k)
    {
        // base case
        if (root == null)
            return null;

        // search in left subtree
        TreeNode left = kthSmallest(root.left, k);

        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;

        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;

        // else search in right subtree
        return kthSmallest(root.right, k);
    }

    public static void main(String args[]){
        int n = 7;
        int k = 3;
        int values[] = {5,3,6,2,4,1,7};
        TreeNode root = null;

        for(int val : values){
            root = insert(root, val);
        }

        
        // Reset count before calling kthSmallest
        count = 0;
        System.out.println(kthSmallest(root, k).val);
    }
}