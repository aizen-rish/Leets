
package rish.leets.grind.easy;

/*
 * 
 * Problem #: 67
 * Problem link: https://leetcode.com/problems/add-binary/
 * 
 * @author Rishabh Soni
 * 
 * Date Attempted: 01/07/2023
 *
 */
public class AddBinary {

	public static String addBinary(String a, String b) {

		char[] add1 = a.toCharArray();
		char[] add2 = b.toCharArray();

		int len1 = add1.length;
		int len2 = add2.length;
		int x = len1 - 1;
		int y = len2 - 1;

		StringBuilder answer = new StringBuilder();
		boolean extraCarry = false;

		while (x >= 0 && y >= 0) {

			char c = add1[x];
			char d = add2[y];

			if (c == d) {
				answer.append(extraCarry ? '1' : '0');
				extraCarry = (c == '1');
			} else {
				answer.append(extraCarry ? '0' : '1');
			}

			x--;
			y--;
		}

		// Loop through extra digits
		if (len1 != len2) {
			int diff = len1 - len2;
			extraCarry = diff > 0 ? addRemaining(answer, add1, diff - 1, extraCarry)
					: addRemaining(answer, add2, -diff - 1, extraCarry);
		}

		if (extraCarry) {
			answer.append('1');
		}

		answer.reverse();
		return answer.toString();
	}

	private static boolean addRemaining(StringBuilder sb, char[] arr, int startIndex, boolean extraCarry) {
		for (int i = startIndex; i >= 0; i--) {
			extraCarry = (arr[i] == '1');
			sb.append(extraCarry ? '0' : '1');
		}
		return extraCarry;
	}

	public static void main(String[] args) {
		System.out.println(addBinary("1111", "1111"));
	}

}
