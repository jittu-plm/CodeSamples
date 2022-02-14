package com.jiten.samples;

public class FinraTest {

	//finding palindram in an efficient way
    //apple
    //madam
    //amda
    //ma a

    public static void main(String[] args) {
        System.out.println(FinraTest.isPalindram("madam"));
    }

    public  static boolean isPalindram(String input){ //amma
        //handle abnormal conditions
        char[] chars = input.toCharArray();
        int length = chars.length; //4
        for (int i = 0; i<length-1;i++){   //i =2
            if(i < (length-1-i)) {//2 < 1
                if (chars[i] != chars[length -1 - i]) { //0   //a a
                    return false;
                }
            }
            else{
                return true;
            }
        }
        return false;
    }

}



