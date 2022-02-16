/**
 * Alice and Bob want to water n plants in their garden. The plants are arranged in a row and are labeled from 0 to n - 1 from left to right where the ith plant is located at x = i.
 *
 * Each plant needs a specific amount of water. Alice and Bob have a watering can each, initially full. They water the plants in the following way:
 *
 * Alice waters the plants in order from left to right, starting from the 0th plant. Bob waters the plants in order from right to left, starting from the (n - 1)th plant. They begin watering the plants simultaneously.
 * It takes the same amount of time to water each plant regardless of how much water it needs.
 * Alice/Bob must water the plant if they have enough in their can to fully water it. Otherwise, they first refill their can (instantaneously) then water the plant.
 * In case both Alice and Bob reach the same plant, the one with more water currently in his/her watering can should water this plant. If they have the same amount of water, then Alice should water this plant.
 * Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith plant needs, and two integers capacityA and capacityB representing the capacities of Alice's and Bob's watering cans respectively, return the number of times they have to refill to water all the plants.
 *
 *
 *
 * Example 1:
 *
 * Input: plants = [2,2,3,3], capacityA = 5, capacityB = 5
 * Output: 1
 * Explanation:
 * - Initially, Alice and Bob have 5 units of water each in their watering cans.
 * - Alice waters plant 0, Bob waters plant 3.
 * - Alice and Bob now have 3 units and 2 units of water respectively.
 * - Alice has enough water for plant 1, so she waters it. Bob does not have enough water for plant 2, so he refills his can then waters it.
 * So, the total number of times they have to refill to water all the plants is 0 + 0 + 1 + 0 = 1.
 * Example 2:
 *
 * Input: plants = [2,2,3,3], capacityA = 3, capacityB = 4
 * Output: 2
 * Explanation:
 * - Initially, Alice and Bob have 3 units and 4 units of water in their watering cans respectively.
 * - Alice waters plant 0, Bob waters plant 3.
 * - Alice and Bob now have 1 unit of water each, and need to water plants 1 and 2 respectively.
 * - Since neither of them have enough water for their current plants, they refill their cans and then water the plants.
 * So, the total number of times they have to refill to water all the plants is 0 + 1 + 1 + 0 = 2.
 * Example 3:
 *
 * Input: plants = [5], capacityA = 10, capacityB = 8
 * Output: 0
 * Explanation:
 * - There is only one plant.
 * - Alice's watering can has 10 units of water, whereas Bob's can has 8 units. Since Alice has more water in her can, she waters this plant.
 * So, the total number of times they have to refill is 0.
 *
 *
 * Constraints:
 *
 * n == plants.length
 * 1 <= n <= 105
 * 1 <= plants[i] <= 106
 * max(plants[i]) <= capacityA, capacityB <= 109
 */
package com.jiten.leetcode.practice;

public class WateringPlants2 {
    public static void main(String[] args) {
        /**
         * Example inputs
         * [2,2,3,3]
         * 5
         * 5
         * [2,2,3,3]
         * 3
         * 4
         * [5]
         * 10
         * 8
         * [2,2,5,2,2]
         * 5
         * 5
         * [7,7,7,7,7,7,7]
         * 8
         * 7
         * [2,1,1]
         *         2
         *         2
         *
         * Failing for -
         * [726,739,934,116,643,648,473,984,482,85,850,806,146,764,156,66,186,339,985,237,662,552,800,78,617,933,481,652,796,594,151,82,183,241,525,221,951,732,799,483,368,354,776,175,974,187,913,842]
         * 1439
         * 1207
         */
        /*int[] plants = new int[] {2,2,3,3};
        int capacityA = 3;
        int capacityB = 4;*/
        /*int[] plants = new int[] {7,7,7,7,7,7,7};//{2,2,3,3};
        int capacityA = 8;
        int capacityB = 7;*/
        /*int[] plants = new int[] {2,2,5,2,2};
        int capacityA = 5;
        int capacityB = 5;*/
       /* int[] plants = new int[] {2,1,1};
        int capacityA = 2;
        int capacityB = 2;*/
        int[] plants = new int[] {726,739,934,116,643,648,473,984,482,85,850,806,146,764,156,66,186,339,985,237,662,552,800,78,617,933,481,652,796,594,151,82,183,241,525,221,951,732,799,483,368,354,776,175,974,187,913,842};
        int capacityA = 1439;
        int capacityB = 1207;
        System.out.println(minimumRefill(plants,capacityA, capacityB));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = 0, b = plants.length-1, refill = 0;;
        int capA = capacityA, capB = capacityB;
        int mid = plants.length/2;
        for(int counter = 0; counter <= plants.length/2;counter++){
            if(a == b ){
                if(plants[a] <= capA || plants[a] <= capB)
                    capA -= plants[a];
                else
                    refill++;
                break;
            }
            if(plants[a] <= capA) {
                capA -= plants[a];
            }
            else {
                capA = capacityA;
                capA -= plants[a];
                refill ++;
            }
            a++;
            if(a > mid)
                break;
            if(plants[b] <= capB){
                capB -= plants[b];
            }
            else {
                capB = capacityB;
                capB -= plants[b];
                refill ++;
            }
            b--;
            if(a > mid || b < mid)
                break;
        }
        return refill;
    }
}
