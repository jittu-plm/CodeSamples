package com.jiten.leetcode.practice;

/**
 * 2183. Count Array Pairs Divisible by K
 * Hard
 *
 * 271
 *
 * 21
 *
 * Add to List
 *
 * Share
 * Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) such that:
 *
 * 0 <= i < j <= n - 1 and
 * nums[i] * nums[j] is divisible by k.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 7
 * Explanation:
 * The 7 pairs of indices whose corresponding products are divisible by 2 are
 * (0, 1), (0, 3), (1, 2), (1, 3), (1, 4), (2, 3), and (3, 4).
 * Their products are 2, 4, 6, 8, 10, 12, and 20 respectively.
 * Other pairs such as (0, 2) and (2, 4) have products 3 and 15 respectively, which are not divisible by 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 0
 * Explanation: There does not exist any pair of indices whose corresponding product is divisible by 5.
 */

public class ArrayPairsDiv {
    public static void main(String[] args) {

    }

    //through iteration - O(n2)
    public long countPairs(int[] nums, int k) {
        long count = 0;
         for(int i=0;i<nums.length;i++){
             for(int j=i+1;j<nums.length;j++) {
                 if(nums[i] * nums[j] % k == 0){
                     count++;
                 }
             }
         }
        count = recCount(0,1,k,0,nums);

         String s = "";

        return count;
    }

    /** Using recursion */
    public long recCount(int i, int j, int k, int count, int[] nums){
        while(j<nums.length) {
            if(nums[i] * nums[j] % k == 0){
                count++;
            }
            j++;
        }
        i = i+1;
        j = i+1;
        if(i < nums.length)
            return recCount(i,j,k,count,nums);
        else
            return count;
    }
}
