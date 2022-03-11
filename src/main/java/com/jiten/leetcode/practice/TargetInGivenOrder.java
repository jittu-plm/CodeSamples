package com.jiten.leetcode.practice;

import java.util.Arrays;

public class TargetInGivenOrder {
    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0};

                //{0,1,2,3,4};
        int[] index = new int[]{0,1,0};
                //{0,1,2,2,1};
        createTargetArray(nums,index);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        Arrays.fill(target, -1);

        for(int i = 0; i< nums.length; i++){
            if(target[index[i]] != -1){
                move(i, nums[i], index[i], target);
            }
            else {
                target[i] = nums[i];
            }
        }
        return target;
    }

    public static int[] move(int i, int num, int index, int[] target){
        while(i > index){
            target[i] = target[i-1];
            i--;
        }
        target[i] = num;
        return target;
    }
}
