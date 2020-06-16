package com.jiten.samples;

/**
 * For Finra
 * Finding square root in norml iterative way, and in efficient way
 */
public class SquareRootTest {

   /* public final  Test1(){

    }*/

    public  int squareRoot(int a){

        //4
        int d = 0;
        int q = 1;
        for(int i =1;i <= a;i++){
            d =  a % i;
            q = a / i;
            if(d == 0 && q == i){
                return i;
            }
        }
        return  0;
    }

    /**
     * Efficient way of finding the squareroot
     * @param a
     * @return
     */

    public static int squareRootBinary(int a ){
        int start = 0, end = a;
        int t = 0;
        while (start < end) {
            t = (start + end) / 2;

            if (t * t == a) {
                return t;
            } else {
                if (t * t > a) {
                    end = t-1;
                } else {
                    start = t+1;
                }
            }
        }
        return  0;
    }


    public static void main(String[] args) {
        System.out.println(squareRootBinary(81));
    }
}
