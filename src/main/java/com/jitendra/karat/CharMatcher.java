package com.jitendra.karat;

import java.util.HashMap;
import java.util.Map;

/**
 * Wayfair interview question -
 *
 *After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.
 *
 * Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.
 *
 * grid1 = [
 * 	['c', 'c', 'x', 't', 'i', 'b'],
 * 	['c', 'c', 'a', 't', 'n', 'i'],
 * 	['a', 'c', 'n', 'n', 't', 't'],
 * 	['t', 'c', 's', 'i', 'p', 't'],
 * 	['a', 'o', 'o', 'o', 'a', 'a'],
 * 	['o', 'a', 'a', 'a', 'o', 'o'],
 * 	['k', 'a', 'i', 'c', 'k', 'i'],
 * ]
 * word1 = "catnip"
 *
 *
 *
 * word2 = "cccc"
 * word3 = "s"
 * word4 = "bit"
 * word5 = "aoi"
 * word6 = "ki"
 * word7 = "aaa"
 * word8 = "ooo"
 *
 * grid2 = [['a']]
 * word9 = "a"
 *
 * find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
 *
 *
 *
 * find_word_location(grid1, word2) =>
 *        [(0, 1), (1, 1), (2, 1), (3, 1)]
 *     OR [(0, 0), (1, 0), (1, 1), (2, 1)]
 *     OR [(0, 0), (0, 1), (1, 1), (2, 1)]
 *     OR [(1, 0), (1, 1), (2, 1), (3, 1)]
 * find_word_location(grid1, word3) => [(3, 2)]
 * find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
 * find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
 * find_word_location(grid1, word6) => [(6, 4), (6, 5)]
 * find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
 * find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
 * find_word_location(grid2, word9) => [(0, 0)]
 *
 * Complexity analysis variables:
 *
 * r = number of rows
 * c = number of columns
 * w = length of the word
 *
 */

public class CharMatcher {
    public static  int rowSize = 0;
    public static  int colSize = 0;
    public static  Map<Integer, Integer> posMap = new HashMap<>();

    public static void main(String[] argv) {
        char[][] grid1 = {
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'c', 's', 'i', 'p', 't'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'o', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'c', 'k', 'i'}
        };
        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "bit";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaa";
        String word8 = "ooo";

        char[][] grid2 = {{'a'}};
        String word9 = "a";

        rowSize = grid1.length;
        colSize = grid1[0].length;

        patternSearch(word1, grid1);
    }



    public static int[][] patternSearch(String word, char[][] grid1){

        for(int i =0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(grid1[i][j] == word.charAt(0)){
                    findMatch(i,j,grid1,word);
                }
            }
        }
        /*char[] chars = word.toCharArray();
        List<int[]> positions = new ArrayList<>();
        int[][] temp = new int[0][0];

        for(int i =0; i < grid1[0].length; i++){
            for(int j=0; j < grid1[0].length; j++){
                if(grid1[i][j] == chars[i]){
                    findMatchHorizontal(grid1[i])
                    temp
                    positions.add();
                }


            }
        }*/
        return null;
    }

    private static boolean findMatch(int row, int col, char[][] grid, String word) {
        for (int i=0; i<2; i++){
            for(int k=1; k< word.length(); k++){
                if(row < rowSize && col < colSize && grid[row][col+1] == word.charAt(k)){
                    col = col + 1;
                    posMap.put(row, col);
                }
                else if(row < rowSize && col < colSize && grid[row+1][col] == word.charAt(k)){
                    row = row + 1;
                    posMap.put(row, col);
                }
                else
                    return false;
            }
        }
        return true;
    }
}
