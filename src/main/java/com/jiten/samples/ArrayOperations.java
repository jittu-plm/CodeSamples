package com.jiten.samples;

import java.util.HashMap;
import java.util.Map;

/**
 * Find numbers, which can give target value by addition
 * For eg: numbers - {2,5,4,7} target - 6
 * result would be 2,4
 * @author jittu
 *
 */
public class ArrayOperations {

    public static void main(String[] args) {
        System.out.println("Hello Java");
        int[] nums = new int[]{2,5,4,7};

        printArray(findMatch(nums,6));
        
        System.out.println();
        seperateEvenOdd(nums);
        
        nums = new int[]{7, 7, 3, 2, 1, 4, 4};
        System.out.println();
        System.out.println(secondMax(nums));
        
    }

    /**
     * return numbers, who can make target by addition
     * @param nums
     * @param target
     * @return
     */
    public static int[] findMatch(int[] nums, int target){
        Map<Integer, Integer> map  = new HashMap<>();
        int                   diff = 0;
        for(int i = 0; i<nums.length;i++){
            diff = target - nums[i];
             if(!map.containsKey(nums[i])) {
                map.put(diff,nums[i]);
             } else {
                 return new int[] {map.get(nums[i]),nums[i]};
            }
        }
        return null;
    }

    public static void printArray(int[] result){
        for (int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
    
    /**
     * seperate odd and even numbers
     * @param a
     */
    private static void seperateEvenOdd(int a[]) {
    	
    	int evenIndex = 0, oddIndex = 0;
    	for (int i = 0; i < a.length; i++) {
    		if(a[i]%2 == 0) {
				evenIndex++;
			}
			else {
				oddIndex++;
			}
    	}
    	int[] even = new int[evenIndex];
    	int[] odd = new int[oddIndex];
    	evenIndex = 0; 
    	oddIndex = 0;
    	
    	for (int i = 0; i < a.length; i++) {
			if(a[i]%2 == 0) {
				even[evenIndex++] = a[i];
			}
			else {
				odd[oddIndex++] = a[i];
			}
		}
    	
    	printArray(even);
    	System.out.println();
    	printArray(odd);
    }
    
    private static void findDivisible(int num) {
    	if(num % 2 == 0 ||
    			num % 3 == 0 
    			) {
    		
    	}
    }
    
    /**
     * find the second Max element in array
     * @param a
     * @return
     */
    private static int secondMax(int[] a) {
    	int first = 0, second = 0;
    	first = second = 0; //3
    	
    	for (int i = 0; i < a.length; i++) {
			if(a[i] > first) {
				second = first;
				first = a[i];
			}
			
			if(a[i] < first && a[i] > second) {
				second = a[i];
			}
		}
    	return second;
    }
    
    
}


/*

class MyCode {
    public static void main (String[] args) {


        MyCode.findMatch(nums, 6)
                .entrySet()
                .stream()
                .filter(e -> e.getKey() + e.getValue() == 6)
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }



}*/
