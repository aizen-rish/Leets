package rish.leets.grind.medium;

import java.util.Stack;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC71
 * 
 * Problem link: https://leetcode.com/problems/simplify-path/
 * 
 * Date Attempted: 08/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SimplifyPaths {

    private static final String CURR_DIR = ".";
    private static final String LAST_DIR = "..";
    private static final String DELIMITTER = "/";

    public static String simplifyPath(String path) {

        String[] folders = path.split(DELIMITTER);
        Stack<String> ans = new Stack<>();

        for (int i = 0; i < folders.length; i++) {

            if (CURR_DIR.equals(folders[i])) {
                continue;
            }

            if (LAST_DIR.equals(folders[i])) {
                if (!ans.isEmpty()) {
                    ans.pop();
                }
                continue;
            }

            if (!folders[i].isEmpty()) {
                ans.add(folders[i]);
            }
        }

        return DELIMITTER + String.join(DELIMITTER, ans);
    }

    public static void main(String[] args) {

        String path = "/../";

        System.out.println(simplifyPath(path));
    }

}
