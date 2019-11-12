package com.jitendra.g4g;

import java.util.ArrayList;
import java.util.List;

public class CircleLatticePoints {

    public static void main(String[] args) {
        for(int i=1;i<=20;i++)
        System.out.println(i + ":" + getLatticePoints(i));
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
