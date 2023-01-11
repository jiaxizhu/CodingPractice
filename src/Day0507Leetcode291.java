import java.util.HashMap;

/**
 * @author zhujiaxi01
 * @date 2022-05-07 16:34
 */
public class Day0507Leetcode291 {
    /**
     * 给你一种规律 pattern 和一个字符串 s，请你判断 s 是否和 pattern 的规律相匹配。
     *
     * 如果存在单个字符到字符串的 双射映射 ，那么字符串 s 匹配 pattern ，即：如果pattern 中的每个字符都被它映射到的字符串替换，那么最终的字符串则为 s 。双射 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，也不会存在一个字符分别映射到两个不同的字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：pattern = "abab", s = "redblueredblue"
     * 输出：true
     * 解释：一种可能的映射如下：
     * 'a' -> "red"
     * 'b' -> "blue"
     * 示例 2：
     *
     * 输入：pattern = "aaaa", s = "asdasdasdasd"
     * 输出：true
     * 解释：一种可能的映射如下：
     * 'a' -> "asd"
     * 示例 3：
     *
     * 输入：pattern = "aabb", s = "xyzabcxzyabc"
     * 输出：false
     *  
     *
     * 提示：
     *
     * 1 <= pattern.length, s.length <= 20
     * pattern 和 s 由小写英文字母组成
     *
     */
    HashMap<Character,String> map = new HashMap<>();
    public boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() == 0) {
            return s.length() == 0;
        }
        char letter = pattern.charAt(0);
        for (int i = 1; i <= s.length() - pattern.length() + 1; i++) {
            String subString = s.substring(0,i);
            String mapStr = map.get(letter);
            if (mapStr != null && mapStr.equals(subString) || mapStr == null && !map.containsValue(subString)) {
                map.put(letter,subString);
                if (wordPatternMatch(pattern.substring(1),s.substring(i))) {
                    return true;
                }
                else if (mapStr == null) {
                    map.remove(letter);
                }
            }
        }
        return false;
    }


}
