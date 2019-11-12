package com.jitendra.leet;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
import  java.util.*;
public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        printArray(ts.twoSum(nums,target));

    }

    public static void printArray(int[] result){
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int delta = 0;
        Map<Integer, Integer> deltaMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            delta = target - nums[i];

            if(!deltaMap.containsKey(nums[i]))
                deltaMap.put(delta,i);
            else
                return new int[] {deltaMap.get(nums[i]),i};
        }
        return null;
    }
}
