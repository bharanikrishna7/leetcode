/*
 * @lc app=leetcode id=2161 lang=java
 *
 * [2161] Partition Array According to Given Pivot
 */

// @lc code=start

import java.util.ArrayList;

class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        // read the values into 3 separate lists
        // based on whether it should go in left - mid - right list
        // which is determined using pivot comparison
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> mid = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                mid.add(pivot);
            }
        }
        // now update the nums array
        // with values in left -> mid -> right (in this order - increasing index)
        int index = 0;
        for (int num : left) {
            nums[index] = num;
            index += 1;
        }
        for (int num : mid) {
            nums[index] = num;
            index += 1;
        }
        for (int num : right) {
            nums[index] = num;
            index += 1;
        }
        return nums;
    }
}
// @lc code=end

