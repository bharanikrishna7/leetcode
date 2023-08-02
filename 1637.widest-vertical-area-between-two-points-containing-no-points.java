/*
 * @lc app=leetcode id=1637 lang=java
 *
 * [1637] Widest Vertical Area Between Two Points Containing No Points
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // sort the array based only on x-axis points
        // this is done to ensure that all points which
        // will be compared don't have a point in between (as it'll not satisfy criteria of the problem)
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // now sweep the array and capture max width between points
        int max_width = 0;
        for (int i = 1; i < points.length - 1; i += 1) {
            if (points[i][0] - points[i - 1][0] > max_width) {
                max_width = points[i][0] - points[i - 1][0];
            }
        }
        return max_width;
    }
}
// @lc code=end

