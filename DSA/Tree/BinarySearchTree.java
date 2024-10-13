public class BinarySearchTree {

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

    static TreeNode inorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    static TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left =  delete(root.left, key);
        } else if(root.val < key){
            root.right = delete(root.right, key);
        } else{
            // case 1
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }

            // case 3
            TreeNode IS = inorderSuccessor(root.right);
            root.val = IS.val;
            root.right  = delete(root.right, IS.val);
        }

        return root;
    }

    static boolean search(TreeNode root, int key){
        if(root == null){
            System.out.println("Not Found!");
            return false;
        }

        if(root.val > key){
            return search(root.left, key);
        } else if(root.val == key){
            System.out.print("Found!");
            return true;
        } else {
            return search(root.right, key);
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

    static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10};
        TreeNode root = null;

        for(int val : values){
            root = insert(root, val);
        }

        inorder(root);
        System.out.println();

        search(root, 8);
        System.out.println();
        
        System.out.println(delete(root, 10).val);
        inorder(root);
    }
}
