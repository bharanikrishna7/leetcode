/*
 * @lc app=leetcode id=1282 lang=java
 *
 * [1282] Group the People Given the Group Size They Belong To
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

// @lc code=start
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // populate in map index of each person
        // based on which group they belong to
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int groupSize;
        for (int index = 0; index < groupSizes.length; index += 1) {
            groupSize = groupSizes[index];
            if(!map.containsKey(groupSize)) {
                map.put(groupSize, new ArrayList<>());
            }
            map.get(groupSize).add(index);
        }

        // for each group size build group
        // with associated people
        List<List<Integer>> groups = new ArrayList<>();
        int maxGroups;
        for (int key : map.keySet()) {
            maxGroups = map.get(key).size() / key;
            for (int index = 0; index < maxGroups; index += 1) {
                groups
                    .add(
                        map
                            .get(key)
                            .subList(
                                key * index,
                                key * (index + 1)
                            )
                    );
            }
        }
        // return generated groups
        return groups;
    }
}
// @lc code=end

