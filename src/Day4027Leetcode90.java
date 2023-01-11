import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-04-27 10:40
 */
public class Day4027Leetcode90 {
    /**
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * @param args
     */
    public static void main(String [] args) {
        int[] arr = new int[]{1,2,2};
        List<List<Integer>> lists = subsetsWithDup(arr);


    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        helper(nums,0,res,list);
        return list;
    }
    private static void helper(int[] nums, int level, List<Integer> res, List<List<Integer>> list) {
        if (level == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[level]);
        helper(nums,level + 1, res, list);
        res.remove(res.size() - 1);
        while (level + 1 < nums.length && nums[level] == nums[level + 1]) {
            level++;
        }
        helper(nums,level + 1, res, list);
    }

    }