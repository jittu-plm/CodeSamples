package com.jitendra.testsamples.amazon;

/**
 * 2 dimensional array
 * 1 - represents the road connectivity
 * 0 - No road connectivity
 * 9 - target
 * Traversal - top,down,left,right only
 */

public class DeliverOrderTest {

    public static void main(String[] args) {
        int[][] twoDimArr = create2DArray();

        System.out.println(traverseArray(twoDimArr));

    }

    public  static int[][] create2DArray(){
//        return new int[][]{
//                {1,1,1},
//                {0,1,1},
//                {0,9,0}
//        };
        return new int[][]{
                {1,1,1},
                {0,0,1},
                {0,9,1}
        };
    }



    public  static int traverseArray(int a[][]){
        int stepCounter = 0;
        int j = 0;
        int rowSize = a.length;
        int colSize = a[0].length;
        for (int i=0;i<a.length;){
            System.out.println("i = " + i + " j = " + j + " a[i][j] = " + a[i][j]);
            if(a[i][j] == 9)
                return stepCounter;
            else if(i == rowSize-1 && j == colSize-1){
                return stepCounter;
            }
            else if(j == colSize-1) {
//                if(a[i+1][j] != 0)
                i++;
//                else j--;
                stepCounter++;
                continue;
            }
            else if(i == rowSize-1) {
//                if(a[i][j+1] != 0)
                j++;
//                else i--;
                stepCounter++;
                continue;
            }
            //go right
            else if(j<colSize && a[i][j+1] != 0){
                j++; stepCounter++;
                continue;
            }
            //go left
            else if(j-1> 0 && a[i][j-1] != 0){
                j--; stepCounter++;
                continue;
            }
            //go up
            else if(i-1>0 && a[i-1][j] != 0){
                i--; stepCounter++;
                continue;
            }
            //go down
            else if(i < rowSize && a[i+1][j] != 0){
                i++; stepCounter++;
                continue;
            }
        }
        return 0;
    }


}
