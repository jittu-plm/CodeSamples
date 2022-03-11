package com.jiten.leetcode.practice;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * 2182. Construct String With Repeat Limit -
 * You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
 *
 * Return the lexicographically largest repeatLimitedString possible.
 *
 * A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cczazcc", repeatLimit = 3
 * Output: "zzcccac"
 * Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
 * The letter 'a' appears at most 1 time in a row.
 * The letter 'c' appears at most 3 times in a row.
 * The letter 'z' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
 * Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
 * Example 2:
 *
 * Input: s = "aababab", repeatLimit = 2
 * Output: "bbabaa"
 * Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa".
 * The letter 'a' appears at most 2 times in a row.
 * The letter 'b' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
 * Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
 *
 */
public class RepeatLimitString {

    public static void main(String[] args) {
//        repeatLimitedString("cczazcc",3);
        repeatLimitedString("aababab",2);
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] c = s.toCharArray();

        char[] res = new char[256];

        Map<Character,Integer> cMap = new TreeMap<>((a,b)->b-a);
        int count = 0;
        for(int i=0;i < s.length();i++){
            System.out.println("char = " + s.charAt(i) + ":" + cMap.get(s.charAt(i)));
            if(cMap.get(s.charAt(i)) != null){
                count = cMap.get(s.charAt(i));
                cMap.put(s.charAt(i),++count);
            }
            else
                cMap.put(s.charAt(i),1);

            // res[s.charAt(i)]++;
        }


        String r = new String();
        String end = "";
        for(Map.Entry<Character,Integer> entry : cMap.entrySet()) {
            System.out.println("entry = " + entry.getKey() + ":" + entry.getValue());
            count = entry.getValue();
            int counter = 0;
            while(count > 0 && counter <  repeatLimit){
                r += entry.getKey();
                count--;
                counter++;
            }
            System.out.println(count + " : " + counter);
            if(count != 0)
                while(counter <=  repeatLimit){
                    end += entry.getKey();
                    counter++;
                }
        }
        return r + end;
    }
}


/**
 * Working solution from LeetCode -
 *
 * public String repeatLimitedString(String s, int repeatLimit) {
 *         PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)->b-a);
 *         for(char ch:s.toCharArray()){
 *         	pq.add(ch);
 *         }
 *         StringBuffer res = new StringBuffer();
 *         ArrayList<Character> list = new ArrayList<Character>();
 *         Stack<Character> stk = new Stack<Character>();
 *         int count = 0;
 *         char previouschar = pq.peek();
 *         while(!pq.isEmpty()){
 *         	char curr = pq.poll();
 *         	if(curr==previouschar){
 *         		if(count<repeatLimit){
 *         			res.append(curr);
 *                                }
 *         		else{
 *         			stk.add(curr);
 *                }
 *         		count++;*         	}
 *         	else{
 *         		if(stk.isEmpty()){
 *         			count=0;
 *         			res.append(curr);
 *         			previouschar = curr;
 *                    nt++;
 *         		}
 *         		else{
 *         			res.append(curr);
 *         			count=0;
 *         			while(!stk.isEmpty() && count<repeatLimit){
 *         				res.append(stk.pop());
 *                         t++;
 *                }
 *            }
 *         	}
 *         }
 *         return res.toString();
 *     }
 */
