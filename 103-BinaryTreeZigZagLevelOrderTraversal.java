/**
 * LEETCODE : 103 (Binary Tree ZigZag level order Traversal)
 * 
 * IN this problem we have to print the zigzag tree level by level
 * 
 * for eg:
 *                       5
 *                     /   \
 *                    /     \
 *                   3       6
 *                 /   \    
 *                /     \  
 *               2       4
 * 
 * in this binary search tree the zigzag level order traversal should be 
 * 
 *      [{5}, {3,6},{4,2}]
 * 
 * ====================================== LOGIC ======================================
 * 
 *  At first we create a list which stores the zigzag order of the BST.
 *  Then we traverse level by level and store the value of that particular
 *  level in the another list, after the level is successfully travelled 
 *  we should check can we reverse the previous level, if yes then we 
 *  simply add the level list in the zigzag list and if NO then we reverse
 *  the level order list and then add it to the zigzag list.
 * 
 *  and finally we return the zigzag list.
 * 
 *  ===================================================================================
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);

        boolean flag = true;

        while(!q.isEmpty()) {

            int size = q.size();

            List<Integer> inner = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                inner.add(node.val);

                if(node.left != null) {
                    q.add(node.left);
                } 
                if(node.right != null) {
                    q.add(node.right);
                }
            }

            if(!flag) {
                Collections.reverse(inner);
            }

            list.add(inner);
            flag = !flag;
        }
        return list;

    }
}