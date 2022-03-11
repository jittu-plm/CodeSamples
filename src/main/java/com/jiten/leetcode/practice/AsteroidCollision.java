package com.jiten.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * ***** Asteroid Collision ******
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 *
 * Constraints:
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] a = new int[]{-2,-1,1,2};
//                {10,2,-5};
//                {-2,-2,2,1};
//                {-2,-2,1,1};
//                {-2,-1,1,2};
//                {-2,-2,-2,-2};
//                {8,-8};
//                {-2,-2,-2,-2};//{-2,-1,1,2};//{5,10,-5};
        System.out.println(asteroidCollision(a));
    }

    public static int[] asteroidCollision(int[] a) {
        boolean collision = false;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=a.length-1;i++){
            if(i == a.length-1) {
                if(!collision)
                    list.add(a[i]);
                break;
            }
            if(a[i] > 0 && a[i+1] > 0){
                if(a[i] < a[i+1]) {
                    System.out.println("a[i] < a[i+1] : "+a[i]+ "<" + a[i+1]);
                    list.add(a[i]);
//                    collision = true;
                }
                else if(a[i] > a[i+1]) {
                    System.out.println("a[i] > a[i+1] : "+a[i]+ ">" + a[i+1]);
                    if(list.size() > 0 && list.get(i) != a[i])
                        list.add(a[i]);
                    a[i+1] = a[i];
//                    collision = true;
                }
                else
                    list.add(a[i]);
            }
            else if(a[i] > 0 && a[i+1] < 0){
                if(-(a[i+1]) > a[i]) {
                    System.out.println("-a[i+1]) > a[i+1] : "+a[i+1] + ":" + a[i]);
                    list.add(a[i+1]);
                    collision = true;
                }
                else if(-(a[i+1]) < a[i]) {
                    System.out.println("-(a[i+1]) < a[i+1] : " + a[i] + ":" + a[i+1]);
                    list.add(a[i]);
                    collision = true;
                }
                else if(Math.abs(a[i]) == Math.abs(a[i+1])){
                    System.out.println("a[i+1] = a[i+1] : "+ a[i] +":" + a[i+1]);
                    // list.add(a[i]);
                    // list.add(a[i+1]);
                    collision = true;
                }
            }
            else
                list.add(a[i]);

        }
        System.out.println(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}


/**
 * Solution -
 *
 * class Solution {
 *     public int[] asteroidCollision(int[] asteroids) {
 *
 *         Deque<Integer> stack = new ArrayDeque<>();
 *
 *         for (int asteroid: asteroids) {
 *
 *             if (asteroid > 0) stack.add(asteroid);
 *
 *             else {
 *                 while (!stack.isEmpty() && stack.peekLast() > 0 && Math.abs(asteroid) > stack.peekLast()) {
 *                     stack.removeLast(); // asteroid moving left will destroy all smaller asteroids moving right
 *                 }
 *                 if (!stack.isEmpty() && Math.abs(asteroid) == stack.peekLast()) stack.removeLast(); // asteroids destroy each other
 *                 else if (stack.isEmpty() || stack.peekLast() < 0) stack.add(asteroid);
 *             }
 *         }
 *
 *         int[] result = new int[stack.size()];
 *
 *         for (int i = stack.size() - 1; i >= 0; i--) {
 *             result[i] = stack.removeLast();
 *         }
 *
 *         return result;
 *     }
 * }

 */