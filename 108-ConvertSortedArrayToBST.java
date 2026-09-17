/**
 *        ===================================== LOGIC ================================
 *          
 *          
 *          At first we create a function which create out BST, the function initially 
 *          contains 3 parameters which is our array, 0 (Starting index), and the 
 *          last index.
 * 
 *          Okay now, 
 *          In the function, we calculate the mid element of our array and then set 
 *          set that element as root of our BST. 
 *          Then we start recursive calls to the function, first we set all left 
 *          nodes, which are from 0 to mid - 1, and after this recursive call ends
 *          then we calculate all right nodes, which are from mid + 1 to the last 
 *          index, 
 *          and finally we return the root .........
 * 
 * 
 * 
 *          ==========================================================================
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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return bst(nums, 0, nums.length - 1);
    }

    private TreeNode bst(int nums[], int left, int right) {

        if(left > right ) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = bst(nums, left, mid - 1);

        root.right = bst(nums, mid + 1, right);

        return root;
    }
}