/*
 * @lc app=leetcode id=2610 lang=java
 *
 * [2610] Convert an Array Into a 2D Array With Conditions
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    private class SetList {
        HashSet<Integer> set;
        ArrayList<Integer> list;

        SetList() {
            set = new HashSet<>();
            list = new ArrayList<>();
        }

        boolean contains(int num) {
            return set.contains(num);
        }

        boolean append(int num) {
            if (!contains(num)) {
                set.add(num);
                list.add(num);
                return true;
            } else {
                return false;
            }
        }

    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<SetList> set_lists = new ArrayList<>();
        boolean added;
        for (int num : nums) {
            added = false;
            for (int i = 0; i < set_lists.size(); i += 1) {
                // if value not present in a set list
                added = set_lists.get(i).append(num);
                if (added) {
                    break;
                }
            }
            if (!added) {
                SetList sl = new SetList();
                sl.append(num);
                set_lists.add(sl);
            }
        }
        return set_lists.stream().map(f -> f.list).collect(Collectors.toList());
    }
}
// @lc code=end

