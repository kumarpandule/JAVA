import java.util.*;

public class LevelOrderTree {

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

    public void levelOrder(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode currentNode = q.remove();
            if(currentNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(currentNode.left == null && currentNode.right == null){
                    System.out.print("");
                }else {
                    System.out.print("  ");
                }
                System.out.print(currentNode.val + " ");
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }
    }

    public static void main(String args[]){
        int nodes[] = {3,9,-1,-1,20,15,-1,-1,7,-1};
        LevelOrderTree t = new LevelOrderTree();
        TreeNode root = t.buildTree(nodes);
        t.levelOrder(root);
    }
}
