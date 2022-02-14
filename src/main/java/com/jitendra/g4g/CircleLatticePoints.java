package com.jitendra.g4g;

import java.util.ArrayList;
import java.util.List;

/**
* lattice point - addition of squares of 2 numbers, should be equal to square of a number
* for eg, lattice points for 5 - {5,5}, {5,-5}, {-5,5}, {-5,-5}, {4,3}, {4,-3}, {-4,3}, {-4,-3}
*/
public class CircleLatticePoints {

    public static void main(String[] args) {
        for(int i=1;i<=20;i++)
        System.out.println(i + ":" + getLatticePoints(i));
//        System.out.println(getLatticePoints(5));
    }

    private static int getLatticePoints(int radius){
        int count = 4;
        int i = 1;
        while(i < radius){
            int jSquare = radius*radius - i*i;
            int j = (int) Math.sqrt(jSquare);
            if (j*j == jSquare){
                count += 4;
            }
            i++;
        }
        return count;
    }
}
