package com.jiten.leetcode.practice;

import java.util.Arrays;

public class MinimumSwaps {
    public static void main(String[] args) {

//        System.out.println(minimumSwap("xxyyxyxyxx",
//                "xyyxyxxxyx"));
        System.out.println(minimumSwap("xy", "yx"));
//        System.out.println(minimumSwap("xx", "xy"));
//        System.out.println(minimumSwap("xx", "yy"));
        /*System.out.println(single("xx", "yy"));
        System.out.println(single("xy", "yx"));
        System.out.println(single("xx", "xy"));*/
    }

    public static int minimumSwap(String s1, String s2) {
        int len = s1.length(), countX1 = 0, countY1 = 0, countX2 = 0, countY2 = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    countX1++;
                } else {
                    countY1++;
                }
                if (s2.charAt(i) == 'x') {
                    countX2++;
                } else {
                    countY2++;
                }
            }
        }

        if ((countX1 + countX2) % 2 == 1) {
            return -1;
        }

        if (countX1 + countX2 > countY1 + countY2) {
            return (int)Math.ceil(countY1 * 1.0 / 2) + (int)Math.ceil(countY2 * 1.0 / 2);
        } else {
            return (int)Math.ceil(countX1 * 1.0 / 2) + (int)Math.ceil(countX2 * 1.0 / 2);
        }
    }


    private static int single(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int swapCount = swapDiagonal(c1, c2);
        if(swapCount != -1)
            return swapCount;
        else {
           return swapVertical(c1,c2);
        }


    }

    private static int swapVertical(char[] c1, char[] c2){
        int count = 0;
        char c= 0;
        c = c1[0];
        c1[0] = c2[0];
        c2[0] = c;
        if(Arrays.equals(c1,c2)){
            return 1;
        }
        else {
            count = swapDiagonal(c1,c2);
            if(count != -1)
                return 2;
            else
                return -1;
        }
//        return -1;
    }
    private static int swapDiagonal(char[] c1, char[] c2){
        char c= 0;
        c = c1[0];
        c1[0] = c2[1];
        c2[1] = c;
        if(String.valueOf(c1).equals(String.valueOf(c2))){
            return 1;
        }
        else {
            c= c1[1];
            c1[1] = c2[0];
            c2[0] = c;
            if(String.valueOf(c1).equals(String.valueOf(c2))){
                return 1;
            }
        }
        return -1;
    }
}
