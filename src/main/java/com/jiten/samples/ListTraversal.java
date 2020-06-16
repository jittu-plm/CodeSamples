package com.jiten.samples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListTraversal {
    //list - 1,2,3,4,5
    //loop


    public static void main(String[] args) {
        List<Integer> intList = IntStream.of(10, 4, 2, 8, 9, 22, 14)
                                .boxed()
                                .collect(Collectors.toList());


        for (int i=0;i<intList.size();i++)
            traverseMyList(intList, i);
        
//        for (int i=0;i<intList.size();i++)
        	traverseMyList1(intList, 2);
    }

    //print numbers in list from the next number to index
    private  static void traverseMyList(List<Integer> list, int index){
		
		for (int i = index; i < list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		for (int i = 0; i < index; i++) {
			System.out.print(" " + list.get(i));
		}
		 
        System.out.println();
    }
    
    // optimized way
    private  static void traverseMyList1(List<Integer> list, int index){ //index 2
        for (int i = index; i < list.size() + index; i++){
            System.out.print(" " + list.get(i%list.size())); //index - 2,3,4,5,6,0,1
        }
        System.out.println();
    }
}


