package com.jitendra.leet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Median calculation for 2 arrays
 * 1. Combine arrays, sort, and then calculate Median
 * for eg: {3}, {-2,-1} result = 3
 *
 */

public class Median {

    public static void main(String[] args) {
        Median median = new Median();
        int[] first = new int[] {};//{1,2};//{3}; //{1,2} {}
        int[] second = new int[] {3};//{-2,-1}; //{3,4} {3}
        System.out.println("Median = " + median.findMedianSortedArrays(first, second));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> firstList = Arrays.stream( nums1 ).boxed().collect( Collectors.toList() );
        List<Integer> secondList = Arrays.stream( nums2 ).boxed().collect( Collectors.toList() );
        firstList.addAll(secondList);
        Collections.sort(firstList);
        firstList.forEach(System.out::println);


        return median(firstList);
    }


    public double median(List<Integer> a){
        return a.size()%2 == 0 ? ((double)(a.get(a.size()/2)+a.get(a.size()/2-1)))/2:a.get(a.size()/2);
//        if(a.size() > 0){
//            int p = 0;
//            if(a.size()%2 == 0){
//                System.out.println(a.size()/2);
//                p = a.size()/2;
//                return ((double)(a.get(p)+a.get(p-1)))/2;
//            }
//            else {
//                return a.get(a.size()/2);
//            }
//
//        }
//        return 0;
    }
}
