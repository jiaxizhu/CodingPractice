import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-06-15 13:49
 */
public class Day0621Leetcode {
    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(allsubSets("abc"));
    }
    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    private static List<String> allsubSets(String n) {
        char[] arr = n.toCharArray();
        List<String> res = new ArrayList<>();
        helper(arr,res,0,new StringBuilder());
        return res;
    }
    private static void helper(char[] arr, List<String> res, int index, StringBuilder sb) {
        if (index == arr.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(arr[index]);
        helper(arr,res,index + 1,sb);
        sb.deleteCharAt(sb.length() - 1);
        helper(arr,res,index + 1,sb);
    }

}








