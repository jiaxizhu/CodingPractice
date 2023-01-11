import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-05-16 16:41
 */
public class Day0516Leetcode93 {
    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
        public static List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            if (s.length() < 4 || s.length() > 12) {
                return result;
            }
            StringBuilder sb = new StringBuilder();
            helper(sb,result,0,0,s.toCharArray());
            return result;
        }
        private static void helper(StringBuilder sb, List<String> result, int index, int level, char[] arr) {
            if (level == 4) {
                if (sb.length() == arr.length + 4) {
                    result.add(sb.substring(0,sb.length() - 1));
                }
                return;
            }
            if (index < arr.length) {
                sb.append(arr[index]).append('.');
                helper(sb,result,index + 1,level + 1,arr);
                sb.delete(sb.length() - 2, sb.length());
            }
            if (index + 1 < arr.length) {
                char a = arr[index];
                if (a != '0') {
                    sb.append(arr[index]).append(arr[index + 1]).append('.');
                    helper(sb,result,index + 2, level + 1, arr);
                    sb.delete(sb.length() - 3, sb.length());
                }
            }
            if (index + 2 < arr.length) {
                char a = arr[index];
                char b = arr[index + 1];
                char c = arr[index + 2];
                if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c <= '5') {
                    sb.append(a).append(b).append(c).append('.');
                    helper(sb,result,index + 3, level + 1, arr);
                    sb.delete(sb.length() - 4, sb.length());
                }
            }
        }
}
