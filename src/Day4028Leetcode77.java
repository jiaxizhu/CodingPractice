import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-04-28 16:19
 */
public class Day4028Leetcode77 {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
     *
     * You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 4, k = 2
     * Output:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     * Example 2:
     *
     * Input: n = 1, k = 1
     * Output: [[1]]
     *
     *
     * Constraints:
     *
     * 1 <= n <= 20
     * 1 <= k <= n
     */
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        helper(n,k,res,list,1);
        return list;
    }
    private static void helper(int n, int k, List<Integer> res, List<List<Integer>> list, int start) {
        if (k == 0) {
            list.add(new ArrayList<>(res));;
            return;
        }
        for (int i = start; i <= n; i++) {
            res.add(i);
            helper(n,k - 1,res,list,i + 1);
            res.remove(res.size() - 1);
        }
    }
}
