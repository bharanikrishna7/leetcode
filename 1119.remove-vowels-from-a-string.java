/*
 * @lc app=leetcode id=1119 lang=java
 *
 * [1119] Remove Vowels from a String
 */

// @lc code=start
class Solution {
    private static final Set<Character> set = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u')
    );

    public String removeVowels(String s) {
        StringBuffer appender = new StringBuffer();
        for (int i = 0; i < s.length(); i += 1) {
            if (!set.contains(s.charAt(i))) {
                appender.append(s.charAt(i));
            }
        }
        return appender.toString();
    }
}
// @lc code=end

