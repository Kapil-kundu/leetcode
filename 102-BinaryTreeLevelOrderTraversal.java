/**
 *  102-Binary Tree Level Order Traversal
 * 
 *  ====================================== LOGIC =======================================
 *  
 *  
 * 
 * 
 *  In this question, we have to return a 2D array which have the sequence of levels
 *  from left to right.
 *  
 *  for Eg -> 
 *                  1
 *                 / \
 *                /   \
 *               2     3
 *              / \   / \
 *             /   \ /   \
 *            4    5 6    7
 *              
 *             
 *          The output must be like this {[1], [2,3], [4,5,6,7]}
 *          
 *          
 *     So the Approach to solve this, USE BFS(Breadth First Search)
 *      
 *        Simply we use a queue of TreeNode, the first element of the queue is the root 
 *          then we iterate queue while it is not empty, while we iterating we simply 
 *          get the size of the queue to know how much elements are on that particular
 *          level, then get left and right node of all the nodes already present in the 
 *          queue and add the new nodes in the queue.
 *          
 *          As well as we push all the values of the nodes in the list and after one 
 *          level is complete we push the the that level in our main or 2D list
 * 
 *      and while the queue is empty we simply return the 2D list   
 * 
 * 
 * ======================================================================================  
        
 **/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null) {
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);

                if(node.left!= null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            output.add(level);
        }
        return output;
    }
}