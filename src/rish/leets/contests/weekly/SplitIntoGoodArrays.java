package rish.leets.contests.weekly;

/*
 * 				Weekly Contest 351
 * 
 * Problem #: 2750
 * Problem link: https://leetcode.com/problems/ways-to-split-array-into-good-subarrays
 * Contest link: https://leetcode.com/contest/weekly-contest-351/
 *
 * @author Rishabh Soni
 * 
 * Date Attempted: 05/07/2023
 */
public class SplitIntoGoodArrays {

	public static int numberOfGoodSubarraySplits(int[] nums) {

		long m = 1000000007;
		long answer = 1;
		int count = 0;

		int i = 0;
		while (i < nums.length && nums[i] == 0) {
			i++;
		}

		if (i == nums.length) {
			return 0;
		}

		for (int j = i; j < nums.length; j++) {
			if (nums[j] == 0) {
				count++;
				continue;
			}
			answer = (answer * (count + 1)) % m;
			count = 0;
		}

		return (int) answer;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1 };
		System.out.println(numberOfGoodSubarraySplits(arr));
	}

}
