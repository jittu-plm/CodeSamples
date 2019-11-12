package com.jitendra.karat;

/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4
 \ /   / | \
  3   5  8  9
   \ / \     \
    6   7    11

Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]

Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4],       // Individuals with zero parents
  [5, 7, 8, 9, 11] // Individuals with exactly one parent
]

n: number of pairs in the input


*/

import java.util.*;

public class ParentChildTest {

    public static void main(String[] argv) {

        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };


        Set<Integer> zeroParent = new HashSet<Integer>();
        Set<Integer> oneParent = new HashSet<Integer>();

        parseForParents(parentChildPairs,zeroParent,oneParent);
        printCollection(zeroParent);
        System.out.println();
        printCollection(oneParent);


    }
    public static void parseForParents(int[][] a, Set<Integer> zeroParentSet, Set<Integer> oneParentSet){
        int counter = 0;
        int m = 0, n = 0;
        List<Integer> childList = new ArrayList<>();
        List<Integer> parentList = new ArrayList<>();
        for(int i = 0;i<a.length;i++)
        {
            //list of parents
            parentList.add(a[i][0]);
            //list of children
            childList.add(a[i][1]);
        }

        //getting zeroParent children
        zeroParentSet.addAll(parentList);
        Set<Integer> intersection = new HashSet<>(parentList);
        intersection.retainAll(childList);
        zeroParentSet.removeAll(intersection);

        //getting one parent children
        prepareOneParentList(oneParentSet, childList);
    }

    private static void prepareOneParentList(Set<Integer> oneParentSet, List<Integer> childList) {
        for(Integer e : childList){
            if(childList.indexOf(e) == childList.lastIndexOf(e)){
                oneParentSet.add(e);
            }
        }
    }

    public static void printCollection(Collection<Integer> set){
        for(Integer i : set)
            System.out.print(i + ":");
    }
}
