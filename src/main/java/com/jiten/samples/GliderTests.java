package com.jiten.samples;

public class GliderTests {

	public static void main(String[] args) {
		String s = "acba";
		int i = findCharToGetPalindram(s);
		if(i >= 0)
		System.out.println("c = " + s.charAt(i));

	}
	
	/**
	 * Glider test for checking Palindram by removing a char.
	 * for eg : abca  in this string if we remove b then aca is a palindram.
	 * if remove 'c', aba is a palindram.
	 * Now b < c, so we need to result b.
	 * 
	 * eg 2: abffb, by remving a, the string is palindram. return a
	 * 
	 */
	private static int findCharToGetPalindram(String s) {
		int low = 0, high = s.length()-1;
		
		while(low < high) {
			if(s.charAt(low) == s.charAt(high)) {
				low ++;
				high --;
			}
			else {
				if(isPalindram(low +1 , high, s))
					return low;
				if(isPalindram(low, high - 1, s))
					return high;
				return -1;
			}
		}
		return -2;
	}
	
	private static boolean isPalindram(int low, int high, String str) {
		while(low < high) {
			if(str.charAt(low) != str.charAt(high)) {
				return false;
			}
			low ++;
			high --;
		}
		return true;
	}

}
