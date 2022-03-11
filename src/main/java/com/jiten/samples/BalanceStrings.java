package com.jiten.samples;

import java.util.ArrayList;
import java.util.List;

public class BalanceStrings {

	public static void main(String[] args) {
		List<String> list = findBalancedSubStrings("RLLLLRRRLR");
		list.forEach(s -> System.out.println(s));

	}
	
	private static List<String> findBalancedSubStrings(String s) {
		List<String> list = new ArrayList<>();
		int rcount = 0, lcount = 0, prevIndex = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'R') {
				rcount ++;
				prevIndex = checkRLCounts(s, list, rcount, lcount, prevIndex, i);
			}
			else if(s.charAt(i) == 'L') {
				lcount ++;
				prevIndex = checkRLCounts(s, list, rcount, lcount, prevIndex, i);
			}
		}
		return list;
	}

	private static int checkRLCounts(String s, List<String> list, int rcount, int lcount, int prevIndex, int i) {
		if(rcount == lcount) {
			list.add(s.substring(prevIndex, i+1));
			prevIndex = i+1;
		}
		return prevIndex;
	}

}
