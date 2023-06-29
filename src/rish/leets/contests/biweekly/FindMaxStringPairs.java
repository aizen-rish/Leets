package rish.leets.contests.biweekly;

import java.util.HashSet;
import java.util.Set;

/*
 * 				Biweekly Contest 107
 * 
 * Problem link: https://leetcode.com/problems/find-maximum-number-of-string-pairs/
 * 
 * Attempt Date: 29/06/2023
 */

public class FindMaxStringPairs {

	public static int maximumNumberOfStringPairs(String[] words) {

		int pairs = 0;
		Set<String> wordPairs = new HashSet<>();

		for (String word : words) {

			if (wordPairs.contains(word)) {
				pairs++;
				continue;
			}

			StringBuilder reverseWord = new StringBuilder();
			reverseWord.append(word);
			reverseWord.reverse();

			if (wordPairs.contains(reverseWord.toString())) {
				pairs++;
				continue;
			}

			wordPairs.add(word);
			wordPairs.add(reverseWord.toString());
		}

		return pairs;
	}

	public static void main(String[] args) {
		System.out.println(maximumNumberOfStringPairs(new String[] { "ab", "ba", "cc" }));
		System.out.println(maximumNumberOfStringPairs(new String[] { "cd", "ac", "dc", "ca", "zz" }));
		System.out.println(maximumNumberOfStringPairs(new String[] { "aa", "ab" }));
	}

}
