package com.jiten.leetcode.practice;

/**
 * 1095. Find in Mountain Array
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
 *
 * You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
 *
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 *
 *
 * Example 1:
 *
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 *
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 *
 *
 * Constraints:
 *
 * 3 <= mountain_arr.length() <= 104
 * 0 <= target <= 109
 * 0 <= mountain_arr.get(index) <= 109
 */


/**
 * sample input -
 * [1,2,3,4,5,3,1]
 * 3
 * [0,1,2,4,2,1]
 * 3
 * [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82]
 * 101
 * [1,5,2]
 * 2
 * [1,5,2]
 * 5
 * [0,5,3,1]
 * 5
 * [3,5,3,2,0]
 * 3
 */
public class MountainArrayProb {
    public static void main(String[] args) {

    }


    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Set<Integer> resultSet = new TreeSet<>((a,b)->a-b);
        int tempSize =0, size = 0;
        tempSize = size = mountainArr.length();
        int temp = 0;
        int i=0, index = -1;
        temp = mountainArr.get(tempSize/2);
        // System.out.println(temp + ":" + (tempSize/2)) ;
        if(target == temp){
            return tempSize/2;
        }
        else {
            if(target < temp){
                i = 0;
                tempSize = (tempSize/2);
            }
            else if(target > mountainArr.get(tempSize/2)){
                i = (tempSize/2);
            }
        }
        // System.out.println(tempSize+":"+i);
        for(;i<tempSize;i++){
            if(target == mountainArr.get(i)){
                // index = i;
                // break;
                return i;
            }
        }

        if(index == -1){
            System.out.println(tempSize+":"+size);
            if(tempSize == size){
                tempSize = size/2;
                i = 0;
                for(;i<tempSize;i++){
                    if(target == mountainArr.get(i)){
                        index = i;
                        break;
                        // return i;
                    }
                }
            }
            for(;i<size;i++){
                if(target == mountainArr.get(i)){
                    index = i;
                    break;
                    // return i;
                }
            }

        }
        return index;

    }

}

class MountainArray {
    int get(int index) {return -1;}
    int length() {return -1;}
}

 /*// This is MountainArray's API interface.
 // You should not implement it, or speculate about its implementation
 interface MountainArray {
      int get(int index) {}
      int length() {}
 }*/
