package rish.leets.contests.weekly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 				Weekly Contest 351
 * 
 * Problem #: 2751
 * Problem link: https://leetcode.com/problems/robot-collisions/
 * Contest link: https://leetcode.com/contest/weekly-contest-351/
 *
 * @author Rishabh Soni
 * 
 * Date Attempted: 29/06/2023
 */
public class RobotCollisions {

	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

		if (directions.indexOf("L") == -1 || directions.indexOf("R") == -1) {
			return Arrays.stream(healths).boxed().collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
