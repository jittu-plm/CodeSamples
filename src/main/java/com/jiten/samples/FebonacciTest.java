package com.jiten.samples;

/**
 * In Prokarma - for TMobile
 */

public class FebonacciTest {

    public static void main(String[] args) {
        fibenocci();
        System.out.println();
        System.out.println("Recursive febo..");
        recFebo(0, 1);
    }


    private static void fibenocci(){
        int sum = 0;
        int first = 0;
        int second = 1;
        for (int i=0; i<10; i++){
            sum = first + second;
            first = second;
            second = sum;
            System.out.println("febonoacci = " + sum);
        }
    }


    private static void recFebo(int f, int s){
        int sum = f + s;
        f = s;
        s = sum;
        System.out.println("febo = " + sum);
        if(sum > 100)
            return;
        recFebo(f,s);
    }
}
