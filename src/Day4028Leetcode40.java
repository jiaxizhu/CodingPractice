import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-04-28 18:57
 */
public class Day4028Leetcode40 {
    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note: The solution set must not contain duplicate combinations.
     *
     *
     *
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     *
     * Constraints:
     *
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     */
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,list,candidates,target,0);
        return list;
    }
    private void helper(List<Integer> res, List<List<Integer>> list, int[] candidates, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(res));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i- 1]) {
                continue;
            }
            res.add(candidates[i]);
            helper(res,list,candidates,target - candidates[i], i + 1);
            res.remove(res.size() - 1);
        }
    }
}
