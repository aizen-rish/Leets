package rish.leets.contests.biweekly;

/*
 * 				Biweekly Contest 107
 * 
 * Problem link: https://leetcode.com/problems/construct-the-longest-new-string/
 * 
 * Attempt Date: 29/06/2023
 */

public class ConstructLongestNewString {

	public static int longestString(int x, int y, int z) {

		int count = 0;

		if (x < y) {
			count = x + x + 1;
		} else if (y < x) {
			count = y + y + 1;
		} else {
			count = x + y;
		}

		return (count + z) * 2;
	}

	public static void main(String[] args) {
		System.out.println(longestString(2, 5, 1));
	}

}
