
import java.util.*;

public class SumOfNodesAtKthLevel {

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

    public long kthLargestLevelSum(TreeNode root, int k){
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        q.add(root);

        while(!q.isEmpty()){
            Queue<TreeNode> nextLevel = new LinkedList<>();
            long sum = 0;

            while(!q.isEmpty()){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
            }

            pq.add(sum);
            if(pq.size() > k){
                pq.poll();
            }

            q = nextLevel;
        }
        return pq.size() < k ? -1 : pq.poll();
    }

    public static void main(String args[]){
        SumOfNodesAtKthLevel t = new SumOfNodesAtKthLevel();
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        int k = 3;

        TreeNode root = t.buildTree(nodes);
         System.out.println(t.kthLargestLevelSum(root, k));
    }
}
