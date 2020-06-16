package com.jiten.samples;

import java.util.Stack;

/**
 * Practice test
 */

/**
 * Infix             Postfix
 * (2+(3*4))        234*+
 * ((a*b)+5)         ab*5+
 * ((1+2)*7)          12+7*
 * ((a*b)/c)             ab*c/
 * (((a/((b-c)+d))*(e-a))*c)                    abc-d+/ea-*c*
 * ((((a/b)-c)+(d*e))-(a*c))             ab/c-de*+ac*-
 */
public class Infix2Postfix {

    public static void main(String[]args){
            System.out.println("postfix = " +  convert("(2+(3*4))"));
    }

    public  static  String convert(String infix){
        String result = "";
        Stack<Character> stack = new Stack<Character>();

        for (int i=0;i<infix.length();i++){
            char c = infix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result = result + c;
            }

            else if(c == '('){
                stack.push(c);
            }

            else if(c == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    result +=  stack.pop();
                }

                if(!stack.isEmpty() && stack.peek() != '('){
                    return "invalid";
                }
                else
                    stack.pop();
            }

            else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())){
                    if(stack.peek() == '(')
                        return "invalid";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }


        return  result;

    }


    static int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
