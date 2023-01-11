import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-05-07 16:55
 */
public class Day0507Leetcode17 {
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     *
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     *
     * Constraints:
     *
     * 0 <= digits.length <= 4
     * digits[i] is a digit in the range ['2', '9'].
     */
    String[] res = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        char[] arr = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arr,sb,result,0);
        return result;
    }
    private void helper(char[]arr, StringBuilder sb, List<String> result, int index) {
        if (index == arr.length) {
            result.add(sb.toString());
            return;
        }
        String temp = res[arr[index] - '0'];
        for (int i = 0 ; i< temp.length(); i++) {
            sb.append(temp.charAt(i));
            helper(arr,sb,result,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
