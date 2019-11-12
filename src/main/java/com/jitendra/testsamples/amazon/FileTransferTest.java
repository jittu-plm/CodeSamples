package com.jitendra.testsamples.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * File Sizes - {4,8,6,12}
 * File Transfer time is same as size.
 * Test is to find out the minimum total transfer time
 * For eg: 4+6 = 10, 10 + 8 = 18, 18 +12 = 30
 * Total = 10+18+30 = 58
 */

public class FileTransferTest<list>
{

    public static void main(String[] args) {

        //define an int array
//        Integer a[] = new Integer[] {4,8,6,12};
        Integer a[] = new Integer[] {8,14,3,12};

        //sort array a
        List<Integer> list = Arrays.asList(a);
        Collections.sort(list);

        int size = list.size();
        int sum = 0;
        for (int i= 0;i<list.size();i++) {
            if(i < size-1) {
                sum = list.get(i) + list.get(i + 1);
                list.set(i + 1, sum);
            }
        }

        list.forEach(System.out::println);

        sum = 0;
        for (int i= 1;i<list.size();i++) {
            sum = sum + list.get(i);
        }


        System.out.printf("total filetransfer time = %d%n", sum);


    }


}
