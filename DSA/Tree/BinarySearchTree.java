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

    static TreeNode delete(TreeNode root, int val){
        if(root.val > val){
            root.left = delete(root.left, val);
        } else if(root.val < val){
            root.right = delete(root.right, val);
        } else {
            // case 1
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // case 3
            TreeNode IS = inorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);

        }

        return root;
    }

    static void search(TreeNode root, int key){
        if(root == null){
            System.out.println("Not Fount!");
            return;
        }
        if(root.val > key){
            search(root.right, key);
        } else if(root.val == key){
            System.out.println(key + " Found!");
        } else{
            search(root.right, key);
        }

    }

    static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
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

    public static void main(String args[]){
        int values[] = {5,3,6,2,4,1,7};
        TreeNode root = null;

        for(int val : values){
            root = insert(root, val);
        }

        inorder(root);

        System.out.println();
        search(root, 5);

        delete(root, 7);

        inorder(root);
    }
}