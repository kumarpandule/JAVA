import java.util.*;

class Main {

    static int count = 0;

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
        }
    }

    static TreeNode insert(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }

        if(root.data > data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }

        return root;
    }

    static TreeNode kthSmallestElement(TreeNode root, int k){
        if(root == null){
            return null;
        }

        TreeNode left = kthSmallestElement(root.left, k);
        if(left != null){
            return left;
        }

        count++;
        if(count == k){
            return root;
        }

        return kthSmallestElement(root.left, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] nodes = new int[n];
        for(int i=0; i<n; i++){
            nodes[i] = scanner.nextInt();
        }

        TreeNode root = null;
        for(int node : nodes){
            root = insert(root, node);
        }

        System.out.print(kthSmallestElement(root, k).data);
    }
}
