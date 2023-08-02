/*
 * @lc app=leetcode id=1874 lang=java
 *
 * [1874] Minimize Product Sum of Two Arrays
 */

// @lc code=start
class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        // sort nums1 and nums2
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // generate product sum by multiplying in forward direction for nums 1 and reverse for nums 2
        int sum = 0;
        for (int i = 0; i < nums1.length; i += 1) {
            sum += nums1[i] * nums2[nums1.length - 1 - i];
        }
        return sum;
    }
}
// @lc code=end

