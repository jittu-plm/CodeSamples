package com.jitendra.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortOfSorted {

    static List<Integer> mergeSorted(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> merged = new ArrayList<>();


        //The below sort is working fine, but it take m(n) iterations
        // merged = sort(a, b);
        // merged = sort(merged, c);

        //o(n) solution
        merged = sort2(a,b,c);


        return merged;
    }

    static int findMax(int a, int b){
        if (a < b)
            return b;
        else
            return a;
    }

    static List<Integer> sort2(List<Integer> a, List<Integer> b, List<Integer> c){
        int size = findMax(findMax(a.size(),b.size()), c.size());
        /*if(a.size() < b.size()){
            if(b.size() < c.size())
                size = c.size();
            else
                size = b.size();
        }
        else{
            if(a.size() < c.size())
                size = c.size();
            else
                size = a.size();
        }*/

        List<Integer> merged = new ArrayList<>();
        for(int i=0; i< size;i++){
            if(i < a.size() && i < b.size()) {
                if(a.get(i) < b.get(i) ){
                    System.out.println(a.get(i)+ ":" + b.get(i));
                    merged.add(a.get(i));
                    if(b.get(i) < c.get(i)) {
                        System.out.println(b.get(i)+ ":" + c.get(i));
                        merged.add(b.get(i));
                        merged.add(c.get(i));
                    }
                    else {
                        System.out.println(c.get(i)+ ":" + a.get(i));
                        merged.add(c.get(i));
                        merged.add(b.get(i));
                    }
                }
                else{
                    System.out.println(a.get(i)+ ":" + b.get(i));
                    merged.add(b.get(i));
                    // merged.add(a.get(i));
                    if(a.get(i) < c.get(i)) {
                        System.out.println(a.get(i)+ ":" + c.get(i));
                        merged.add(a.get(i));
                        merged.add(c.get(i));
                    }
                    else {
                        System.out.println(c.get(i)+ ":" + a.get(i));
                        merged.add(c.get(i));
                        merged.add(a.get(i));
                    }
                }
                System.out.println(merged);
            }
            else
                merged.add(a.get(i));
        }
        return merged;

    }



    static List<Integer> sort(List<Integer> a, List<Integer> b){
        List<Integer> merged = new ArrayList<>();
        int size = 0;
        if(a.size() > b.size())
            size = a.size();
        else
            b.size();
        int index = 0;
        for(int i=0; i< size;i++){
            if(i < a.size() && i < b.size()) {
                if(a.get(i) < b.get(i) ){
                    // System.out.println(a.get(i)+ ":" + b.get(i));
                    merged.add(a.get(i));
                    merged.add(b.get(i));
                }
                else{
                    // System.out.println(a.get(i)+ ":" + b.get(i));
                    merged.add(b.get(i));
                    merged.add(a.get(i));
                }
                // System.out.println(merged);
            }
            else
                merged.add(a.get(i));
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> b = Arrays.asList(2, 4, 5, 6);
        List<Integer> c = Arrays.asList(2, 3, 3);

        List<Integer> merged = mergeSorted(a, b, c);
        List<Integer> expected = Arrays.asList(1,2,2,3,3,3,4,5,5,6,7,9,11);
        System.out.println(expected + " expected");
        System.out.println(merged);
    }
}
