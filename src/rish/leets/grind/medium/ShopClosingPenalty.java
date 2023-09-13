package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: 2483
 * Problem link: https://leetcode.com/problems/minimum-penalty-for-a-shop/
 * 
 * Date Attempted: 29/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ShopClosingPenalty {

    public static int bestClosingTime(String customers) {

        int len = customers.length();

        int j = 0;
        while (j < len && customers.charAt(j) == 'Y') {
            j++;
        }

        if (j == len) {
            return j;
        }

        int[] nSum = new int[len - j + 1];
        int[] ySum = new int[len - j + 1];

        nSum[0] = 0;
        for (int i = 1; i <= len - j; i++) {
            nSum[i] = nSum[i - 1];
            if (customers.charAt(i - 1 + j) == 'N') {
                nSum[i]++;
            }
        }

        ySum[len - j] = 0;
        for (int i = len - j - 1; i >= 0; i--) {
            ySum[i] = ySum[i + 1];
            if (customers.charAt(i + j) == 'Y') {
                ySum[i]++;
            }
        }

        int ans = -1;
        int minPen = Integer.MAX_VALUE;

        for (int i = j; i <= len; i++) {
            int penalty = ySum[i - j] + nSum[i - j];
            if (penalty < minPen) {
                minPen = penalty;
                ans = i;
            }
        }

        return ans;
    }

    public static int bestClosingTime2(String customers) {

        int len = customers.length();

        int penalty = 0;
        int minPenalty = 0;
        int ans = 0;

        for (int i = 0; i < len; i++) {

            penalty += customers.charAt(i) == 'Y' ? -1 : 1;

            if (minPenalty > penalty) {
                minPenalty = penalty;
                ans = i + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String cus = "YYNY";
        System.out.println(bestClosingTime(cus));

    }

}
