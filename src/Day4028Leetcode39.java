import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-04-28 18:56
 */
public class Day4028Leetcode39 {
    /**
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     *
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     *
     * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     *
     *
     *
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     *
     * Input: candidates = [2], target = 1
     * Output: []
     *
     *
     * Constraints:
     *
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * All elements of candidates are distinct.
     * 1 <= target <= 500
     */

    public static void main(String[] args) {
        int[] res = new int[]{2,3,5};
        List<List<Integer>> lists = combinationSum(res, 8);
        int a = 0;

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates,target,res,list,0);
        return list;
    }
    private static void helper(int[] candidates, int target, List<Integer> res, List<List<Integer>> list, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(res));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            res.add(candidates[i]);
            helper(candidates,target - candidates[i], res, list,i);
            res.remove(res.size() - 1);
        }
    }
}
