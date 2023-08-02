/*
 * @lc app=leetcode id=1769 lang=java
 *
 * [1769] Minimum Number of Operations to Move All Balls to Each Box
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public int[] minOperations(String boxes) {
        // keep track of moves required
        int[] moves = new int[boxes.length()];
        // keep track of moves required (in backtrack)
        int[] backtrack = new int[boxes.length()];
        // number of boxes encountered in pass (iteration)
        int to_add = 0;
        // check if first char was a box
        if (boxes.charAt(0) == '1') {
            to_add += 1;
        }
        // when moving from left to right (does not take care of backtrack)
        // moves[i] = moves[i - 1] + number_of_boxes_encountered
        for (int i = 1; i < boxes.length(); i += 1) {
            moves[i] = moves[i - 1] + to_add;
            if (boxes.charAt(i) == '1') {
                to_add += 1;
            }
        }
        // prepare for reverse sweep (iteration)
        to_add = 0;
        // check if last char was a box
        if (boxes.charAt(boxes.length() - 1) == '1') {
            to_add += 1;
        }
        // when sweeping from right to left (the logic remains same, but we need separate variable to store moves required)
        // backtrac[i] = backtrack[i + 1] + number_of_boxes_encountered
        for (int i = boxes.length() - 2; i >= 0; i -= 1) {
            backtrack[i] += backtrack[i + 1] + to_add;
            if (boxes.charAt(i) == '1') {
                to_add += 1;
            }
        }
        // now add the backtrack moves (to capture right to left)
        // to moves at same respective indices
        for (int i = 0; i < boxes.length(); i += 1) {
            moves[i] += backtrack[i];
        }
        // return prepared result
        return moves;
    }
}
// @lc code=end

