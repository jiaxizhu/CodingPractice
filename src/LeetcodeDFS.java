/**
 * @author zhujiaxi01
 * @date 2022-06-21 14:13
 */

import com.sun.org.apache.xpath.internal.operations.VariableSafeAbsRef;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetcodeDFS {
    public static void main(String[] args) {
        String s = "aab";
        String s123 = "1.2.3.4";
        String[] temp = s123.split(".");
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<String> res = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        helper(res,list,s,0);
        return list;
    }
    private static void helper(List<String> res, List<List<String>> list, String s, int index) {
        if (index == s.length()) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index,i + 1);
            if (!isValid(temp)) {
                continue;
            }
            res.add(temp);
            helper(res,list,s, i + 1);
            res.remove(res.size() - 1);
        }
    }
    private static boolean isValid(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }







}
