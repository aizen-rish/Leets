package rish.leets.contests.weekly;

/*
 * 				Weekly Contest 352
 * 
 * Problem #: 2760
 * Problem link: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
 * 
 * Attempt Date: 04/07/2023
 */
public class EvenOddSubArrays {

	public static int longestAlternatingSubarray(int[] nums, int threshold) {

		int maxCount = 0;
		int curCount = 0;

		boolean isNextOdd = false;

		for (int i = 0; i < nums.length; i++) {

			int a = nums[i];

			if (a > threshold) {
				System.out.println("exit 1");
				isNextOdd = false;
				curCount = 0;
				continue;
			}

			if (isNextOdd && a % 2 == 0) {
				System.out.println("exit 2");
				isNextOdd = false;
				curCount = 0;
				i--;
				continue;
			}

			if (!isNextOdd && a % 2 != 0) {
				System.out.println("exit 3");
				isNextOdd = false;
				curCount = 0;
				continue;
			}

			isNextOdd = !isNextOdd;
			curCount++;
			maxCount = Math.max(maxCount, curCount);
		}

		return maxCount;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2 };
		int thresh = 10;

		System.out.println(longestAlternatingSubarray(arr, thresh));
	}

}
