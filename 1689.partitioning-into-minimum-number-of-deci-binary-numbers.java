/*
 * @lc app=leetcode id=1689 lang=java
 *
 * [1689] Partitioning Into Minimum Number Of Deci-Binary Numbers
 */

// @lc code=start
class Solution {
    public int minPartitions(String n) {
        // observing the input
        // the maximum number of deci-binary values required
        // should be max value of encountered digits
        int result = 0;
        for (char c : n.toCharArray()) {
            if (result < c - '0') {
                result = c - '0';
            }
        }
        return result;
    }
}
// @lc code=end

