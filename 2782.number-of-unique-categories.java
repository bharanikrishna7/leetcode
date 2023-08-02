/*
 * @lc app=leetcode id=2782 lang=java
 *
 * [2782] Number of Unique Categories
 */

// @lc code=start

import java.util.HashSet;

/**
 * Definition for a category handler.
 * class CategoryHandler {
 *     public CategoryHandler(int[] categories);
 *     public boolean haveSameCategory(int a, int b);
 * };
 */
class Solution {
	public int numberOfCategories(int n, CategoryHandler categoryHandler) {
    // based on the constraints	
		// 1 <= value <= n
		
		// variable holding unique element from each set
		HashSet<Integer> category_unique_elements = new HashSet<>();
		for (int index = 0; index <= n; index += 1) {
			// check if index part of accounted set
			boolean is_accounted = false;
			for (int category_unique_element : category_unique_elements) {
				if (categoryHandler.haveSameCategory(category_unique_element, index)) {
					is_accounted = true;
					break;
				}
			}
			// if not accounted then index belongs to new category
			// so add it to unique categories
			if (!is_accounted) {
				category_unique_elements.add(index);
			}
		}
		// this brings in 1 extra count
		// so make sure to remove it
		return category_unique_elements.size() - 1;
	}
}
// @lc code=end

