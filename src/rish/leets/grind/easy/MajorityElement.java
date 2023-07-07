package rish.leets.grind.easy;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 169
 * Problem link : https://leetcode.com/problems/majority-element/
 * 
 * @author Rishabh Soni
 *
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {

        int cand = -1;
        int vote = 0;

        for (int i = 0; i < nums.length; i++, vote++) {
            if (vote == 0) {
                cand = nums[i];
            } else {
                if (cand != nums[i]) {
                    vote -= 2;
                }
            }
        }

        return cand;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
    }

}
