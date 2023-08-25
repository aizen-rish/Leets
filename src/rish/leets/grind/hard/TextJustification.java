package rish.leets.grind.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * Daily Challenge!
 * 
 * Problem #: 68
 * Problem link: https://leetcode.com/problems/text-justification/
 * 
 * Date Attempted: 24/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class TextJustification {

    private static final String SPACE = " ";

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            List<String> subAns = new ArrayList<>();

            int count = 0;

            while (i < words.length) {

                int len = words[i].length();

                if (count + len > maxWidth) {
                    break;
                }
                subAns.add(words[i]);
                count += len + 1;
                i++;
            }

            int spaces = maxWidth - count + subAns.size();
            int boxes = subAns.size() - 1;

            if (boxes == 0 || i == words.length) {

                StringBuilder sb = new StringBuilder();
                sb.append(spacify(subAns, SPACE, 0));

                String delimitter = SPACE.repeat(maxWidth - count + 1);
                sb.append(delimitter);

                ans.add(sb.toString());
                continue;
            }

            String delimitter = SPACE.repeat(spaces / boxes);

            int extraSpaces = spaces % boxes;
            ans.add(spacify(subAns, delimitter, extraSpaces));
        }

        return ans;
    }

    private static String spacify(List<String> words, String delimitter, int extraSpaces) {

        if (extraSpaces == 0) {
            return String.join(delimitter, words);
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < words.size(); j++) {

            String s = words.get(j);
            sb.append(s);

            if (j != words.size() - 1) {
                sb.append(delimitter);
            }

            if (extraSpaces > 0) {
                sb.append(SPACE);
                extraSpaces--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String[] words = { "What", "must", "be", "acknowledgment", "shall", "be" };

        System.out.println(fullJustify(words, 16));
    }

}
