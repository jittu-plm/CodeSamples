package com.jitendra.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Median {

	public static void main(String[] args) {
		Median med = new Median();
		int[] nums1 = new int[] {1, 3}; //[1, 2]
		int[]nums2 = new int[] {2}; //[3, 4]
		//The median is 2.0
		System.out.println(med.findMedianSortedArrays(nums1, nums2));

	}
	
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         List<Integer> firstList = Arrays.stream( nums1 ).boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream( nums2 ).boxed().collect(Collectors.toList());
        firstList.addAll(secondList);
        Collections.sort(firstList);
        // return median(firstList);
        return firstList.size()%2 == 0 ? ((double)(firstList.get(firstList.size()/2)+firstList.get(firstList.size()/2-1)))/2:firstList.get(firstList.size()/2);

    }

}

class Solution {
   
}
