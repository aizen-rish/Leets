package rish.leets.grind.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 409
 * Problem link: https://leetcode.com/problems/longest-palindrome/
 * 
 * Date Attempted: 12/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer val = freqMap.getOrDefault(c, 0);
            freqMap.put(c, val + 1);
        }

        int maxLength = 0;
        boolean hasOdd = false;

        for (Integer freq : freqMap.values()) {
            maxLength += freq % 2 == 0 ? freq : freq - 1;
            hasOdd |= freq % 2 != 0;
        }

        if (hasOdd) {
            maxLength += 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
    }

}
