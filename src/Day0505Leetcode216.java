import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-04-28 18:58
 */
public class Day0505Leetcode216 {
    /**
     *Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
     *
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Explanation:
     * 1 + 2 + 4 = 7
     * There are no other valid combinations.
     * Example 2:
     *
     * Input: k = 3, n = 9
     * Output: [[1,2,6],[1,3,5],[2,3,4]]
     * Explanation:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * There are no other valid combinations.
     * Example 3:
     *
     * Input: k = 4, n = 1
     * Output: []
     * Explanation: There are no valid combinations.
     * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
     *
     *
     * Constraints:
     *
     * 2 <= k <= 9
     * 1 <= n <= 60
     */
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 7);
        int t = 2;


    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        helper(res,list,k,n,1,1,0);
        return list;
    }
    private static void helper(List<Integer> res, List<List<Integer>> list, int k, int n, int start, int level, int sum) {
        if (level == k + 1) {
            if (sum == n) {
                list.add(new ArrayList<>(res));
            }
            return;
        }
        if (level > k + 1) {
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i = start; i < 10; i++) {
            sum += i;
            res.add(i);
            helper(res,list,k,n, i + 1,level + 1,sum);
            res.remove(res.size() - 1);
            sum -= i;
        }
    }
}
