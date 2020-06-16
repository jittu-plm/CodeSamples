package com.jiten.samples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Asked by compugain for Finra
 */
public class DuplicateDataRemover {


    public static void deleteDuplicate(int N, int a[]) {
        int result=-404;
        //write your Logic here:
        int[] t = new int[a.length];
        int k = 0;
        boolean b = false;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i] == a[j]){
                    a[j] = -1;
                    b = true;
                }
            }
            if(!b){
                t[k++] = a[i];
            }
            b = false;
        }
        prinArr(t);
        //sort array
        a = sortArr(a);


        System.out.println(a.length);
        prinArr(a);
    }

    public static int[] sortArr(int[] a){
        int temp = 0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j] > 0 && a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        int count = 0;
        //count the positive elements
        for(int i=0;i< a.length;i++){
            if(a[i] != -1){
                count++;
            }
        }

        //move positive elements to another array
        int[] b = new int[count];
        int c = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] != -1){
                b[c++] = a[i];
            }
        }


        // prinArr(b);
        return b;
    }

    public static void prinArr(int[] a){
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }


    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
       int[] a = new int[]{10,8,8,4,4,1,-1};

        // OUTPUT [uncomment & modify if required]
        deleteDuplicate(a.length,a);
        System.out.println();
        removeDuplicates(a);
        System.out.println();
        removeDups(a);

        System.out.println();
        removeDupl(a);
    }

    //removing duplicates using java 8
    //using TreeSet
	private static void removeDuplicates(int[] a) {
		// TODO Auto-generated method stub
		Set<Integer> set = new TreeSet<>();
		Arrays.stream(a)
		.filter(i -> set.add(i))
		.sorted()
		.forEach(i -> System.out.print(i + " "));
	}
	
	//removing duplicates Java7
	//using treeset
	private static void removeDups(int[] a) {
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		set.forEach(i -> System.out.print(i + " "));
	}
	
	
	/**
	 * removing duplicates by using HashMap, Java7
	 * @param a
	 */
	private static void removeDupl(int[] a) {
		Map<Integer, Boolean> map = new HashMap<>();
		
		for (int i = 0; i < a.length; i++) {
			if(!map.containsKey(a[i])) {
				System.out.print(a[i] + " ");
			}
			map.put(a[i], true);
		}
	}
}


/*
import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void deleteDuplicate(int N, int a[]) {
        int result=-404;
        //write your Logic here:
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i] == a[j]){
                    a[j] = -1;
                }
            }
        }

        //sort array
         a = sortArr(a);


        System.out.println(a.length);
        for(int i=0; i<N; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static int[] sortArr(int[] a){
        int temp = 0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j] > 0 && a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        int count = 0;
        //count the positive elements
        for(int i=0;i< a.length;i++){
            if(a[i] != -1){
                count++;
            }
        }

        //move positive elements to another array
        int[] b = new int[count];
        for(int i=0;i<a.length;i++){
            if(a[i] != -1){
                b[i] = a[i];
            }
        }


        // prinArr(b);
        return b;
    }

    public static void prinArr(int[] a){
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int A [] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        // OUTPUT [uncomment & modify if required]
        deleteDuplicate(N,A);
        sc.close();
    }
}
 */
