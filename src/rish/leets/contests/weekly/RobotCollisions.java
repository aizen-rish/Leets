package rish.leets.contests.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 *            Weekly Contest 351
 * 
 * Problem #: 2751
 * Problem link: https://leetcode.com/problems/robot-collisions/
 * Contest link: https://leetcode.com/contest/weekly-contest-351/
 *
 * Date Attempted: 08/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class RobotCollisions {

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        if (directions.indexOf("L") == -1 || directions.indexOf("R") == -1) {
            return Arrays.stream(healths).boxed().collect(Collectors.toList());
        }

        Map<Integer, Integer> robotIndexMap = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            robotIndexMap.put(positions[i], i);
        }

        Arrays.sort(positions);

        Stack<Integer> rightMoving = new Stack<>();
        for (int i = 0; i < positions.length; i++) {

            int robotIndex = robotIndexMap.get(positions[i]);
            char direction = directions.charAt(robotIndex);

            if (direction == 'R') {
                rightMoving.push(positions[i]);
                continue;
            }

            boolean isBattleOver = false;
            while (!rightMoving.isEmpty() && !isBattleOver) {

                int xIndex = robotIndex;
                int yIndex = robotIndexMap.get(rightMoving.peek());

                int healthDiff = healths[xIndex] - healths[yIndex];

                boolean isVictorious = healthDiff >= 0;
                if (isVictorious) {
                    rightMoving.pop();
                }

                healths[xIndex] = healthDiff > 0 ? healths[xIndex] - 1 : 0;
                healths[yIndex] = healthDiff < 0 ? healths[yIndex] - 1 : 0;

                isBattleOver = healthDiff <= 0;
            }
        }

        return Arrays.stream(healths).boxed().filter(i -> i != 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int[] pos = { 4, 37, 23 };
        int[] healths = { 50, 15, 49 };
        String directions = "RLR";

        System.out.println(survivedRobotsHealths(pos, healths, directions));
    }

}
