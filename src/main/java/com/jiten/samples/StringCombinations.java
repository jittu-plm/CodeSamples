package com.jiten.samples;

import java.util.*;


/*
 * got this question in resolvetech exam.
 * given a string - bacd. We have to get the combinations of this string like
 * b,ba,bac,bacd, a,ac,acd, c,cd etc.
 * Then we need to sort the resultant strings
 */
public class StringCombinations {
    static char[] count = new char[256];
    
	public static void main(String[] args) {
		// write all combinations of substrings in a given string,
		// and sort them
		splitString("bacd");
		System.out.println();
		
		//print list from the given index
		String[] nameArr = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha", "SKeshav", "Jiten", "Chakram", "Sai"};
        stringSample(nameArr);
		System.out.println();
        
        //find first non-repeatable char
        System.out.println(getFirstNonRepeatable("jjiittu"));
		System.out.println();
	}
	
	/**
	 * split Strings into substrings, and sort 
	 */
	private static void splitString(String s) {
		
		Set<String> set = new TreeSet<String>();
		for (int i = 0; i < s.length(); i++) {
			set.add(String.valueOf(s.charAt(i)));
			for (int j = i+1; j < s.length(); j++) {
				set.add(s.substring(i, j+1));
			}
		}
		printSet(set);
	}
	
	private static void printSet(Set<String> set) {
		set.stream()
		.forEach(s -> System.out.print(s + " "));
	}

	/**
     * add, sort, reverse strings
     * @param str
     */
    public static void stringSample(String[] str){
        Set<String> set = new TreeSet<>((s,t) -> {
           return  t.compareTo(s);
        });

        for (int i=0;i<str.length;i++){
            set.add(str[i]);
        }
        set.stream()
                .forEach(s -> System.out.print(s + " "));

       /* Arrays.stream(str).
                filter(s -> set.add(s))
                .forEach(s -> System.out.print(s + " "));
*/
    }
    
    
    /**
     * Finds first non-repeatable char
     */
    static char getFirstNonRepeatable(String s){
        char[] c = s.toCharArray();
        getCharCount(s);

        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            System.out.println(ch + " = " + ((int)count[ch]));
            if(count[s.charAt(i)] == 1)
                return s.charAt(i);
        }
        return 0;
    }

    private static void getCharCount(String s) {
        for (int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
    }
}



