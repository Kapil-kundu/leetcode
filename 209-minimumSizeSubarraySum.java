		
/**
 *  
 * Question :-> 209 (LEETCODE)
 * 
 *  Find The Minimal Length Of A Subarray Which Have The Sum Greater Or Equal To
 *  The Target
 * 
 *  ======================================= LOGIC ====================================
 * 
 *  the initial length should be the Integer.MAX_VALUE
 *  
 *  The logic is to find the first subarray whose sum is greater or equal to the target
 *  then from left side decrease the sum of the subarray as well as decrease the length
 *  value, then move forward also process the value of length in which case we have got 
 *  the minimum length, and repeat this process until we reaches to the last index of the
 *  array
 * 
 *  and at last return check if the length still equals to the Integer.MAX_VALUE, if it 
 *  is then return 0, length = Integer.MAX_VALUE means the nums array does not contain
 *  any subarray which have greater or equal sum to the target, else return the minimum
 *  length of subarray
 **/




class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int high = 0;
        int low = 0;
        int result = Integer.MAX_VALUE;

        int tempSum = 0;
        for(high = 0; high < nums.length; high++) {
            tempSum += nums[high];

            while(tempSum >= target) {
                result = Math.min(result, high - low + 1);
                tempSum -= nums[low];
                low++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
