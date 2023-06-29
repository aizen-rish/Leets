package rish.leets.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

record Pair(int x, int y) {
}

class Solution {

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<Pair> breaks = new ArrayList<>();

		// find breaks instead
		for (int i = 0; i < intervals.length - 1; i++) {
			breaks.add(new Pair(intervals[i][1], intervals[i + 1][0]));
		}

		System.out.println(breaks.toString());

		// filter out breaks overlapping with new interval
		breaks = breaks.stream().filter(pair -> pair.x() < newInterval[0] || pair.y() > newInterval[1])
				.collect(Collectors.toList());

		System.out.println(breaks.toString());

		// create intervals back
		Set<List<Integer>> answer = new HashSet<>();

		for (int i = 0; i < intervals.length - 1; i++) {

			Pair pair = new Pair(intervals[i][1], intervals[i + 1][0]);
			if (breaks.contains(pair)) {
				answer.add(Arrays.asList(intervals[i][0], intervals[i][1]));
			}
		}

		return intervals;
	}

	public int[][] insert2(int[][] intervals, int[] newInterval) {

		int size = intervals.length;
		if (size == 0) {
			return new int[][] { newInterval };
		}

		// Check if new interval is completely out of bounds
		if (intervals[0][0] > newInterval[1] || intervals[size - 1][1] < newInterval[0]) {

			boolean insertLeft = intervals[0][0] > newInterval[1];
			int inserIndex = insertLeft ? 0 : size;
			int offset = insertLeft ? 1 : 0;

			int[][] answer = new int[size + 1][2];
			answer[inserIndex] = newInterval;
			for (int i = 0; i < size; i++) {
				answer[i + offset] = intervals[i];
			}

			return answer;
		}

		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> previousWindow = Collections.emptyList();
		boolean anyOverlappingFound = false;

		for (int i = 0; i < intervals.length; i++) {

			if (isOverlapping(intervals[i], newInterval)) {

				anyOverlappingFound = true;

				// find combined window with new interval
				int left = Math.min(intervals[i][0], newInterval[0]);
				int right = Math.max(intervals[i][1], newInterval[1]);

				List<Integer> newRange = Arrays.asList(left, right);

				if (!previousWindow.isEmpty() && isOverlapping(newRange.stream().mapToInt(Integer::intValue).toArray(),
						previousWindow.stream().mapToInt(Integer::intValue).toArray())) {

					int newLeft = Math.min(previousWindow.get(0), newRange.get(0));
					int newRight = Math.max(previousWindow.get(1), newRange.get(1));
					newRange = Arrays.asList(newLeft, newRight);

					if (newRange.equals(previousWindow)) {
						continue;
					}

					if (range(newRange) > range(previousWindow)) {
						answer.remove(previousWindow);
					}
				}

				previousWindow = newRange;
				answer.add(newRange);
			} else {
				previousWindow = Arrays.asList(intervals[i][0], intervals[i][1]);
				answer.add(Arrays.asList(intervals[i][0], intervals[i][1]));
			}
		}

		if (!anyOverlappingFound) {
			// add interval manually
			for (int i = 0; i < answer.size() - 1; i++) {
				if (answer.get(i).get(1) < newInterval[0] && newInterval[1] < answer.get(i + 1).get(0)) {
					answer.add(i + 1, Arrays.asList(newInterval[0], newInterval[1]));
				}
			}
		}

		return answer.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
	}

	public int[][] insert3(int[][] intervals, int[] newInterval) {

		int size = intervals.length;
		if (size == 0) {
			return new int[][] { newInterval };
		}

		List<int[]> answer = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (intervals[i][1] < newInterval[0]) {
				answer.add(intervals[i]);
			} else if (intervals[i][0] > newInterval[1]) {
				answer.add(newInterval);
				newInterval = intervals[i];
			} else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) {
				// find combined window with new interval
				newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
				newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			}
		}

		answer.add(newInterval);
		return answer.toArray(int[][]::new);
	}

	private boolean isOverlapping(int[] source, int[] query) {
		return source[0] <= query[1] && source[1] >= query[0];
	}

	private int range(List<Integer> interval) {
		return interval.get(1) - interval.get(0);
	}

}

public class InsertInterval {

	public static void main(String[] args) {

		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };

		Solution sol = new Solution();
//		sol.insert(intervals, newInterval);
		int[][] answer = sol.insert3(intervals, newInterval);
		System.out.println(Arrays.deepToString(answer));
	}

}
