package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * Daily Challenge!
 * 
 * Problem #: LC215
 * Problem link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Date Attempted: 14/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> test = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return quickSelect(test, test.size() - k + 1);
    }

    private static int quickSelect(List<Integer> nums, int k) {

        int random = new Random().nextInt(nums.size());
        int pivot = nums.get(random);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        nums.forEach(num -> {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        });

        if (left.size() >= k) {
            return quickSelect(left, k);
        }

        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }

        return pivot;
    }

}
