package rish.leets.grind.easy;

/**
 * Daily Challenge!
 * 
 * Problem #: LC844
 * 
 * Problem link: https://leetcode.com/problems/backspace-string-compare/
 * 
 * Date Attempted: 19/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        int i = sLen - 1;
        int j = tLen - 1;

        int iback = 0;
        int jback = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {

                char ic = s.charAt(i);

                if (ic == '#') {
                    iback++;
                    i--;
                } else if (iback > 0) {
                    iback--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {

                char jc = t.charAt(j);

                if (jc == '#') {
                    jback++;
                    j--;
                } else if (jback > 0) {
                    jback--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if (i == -1 && j >= 0) {
                return false;
            }

            if (j == -1 && i >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

}
