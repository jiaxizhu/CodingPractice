import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-05-06 09:42
 */
public class Day0506Leetcode47 {
    /**
     * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,2]
     * Output:
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * Example 2:
     *
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,list,0);
        return list;
    }
    private void helper(int[] nums, List<List<Integer>> list, int index) {
        if (index == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            list.add(new ArrayList<>(res));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums,i,index);
                helper(nums,list,index + 1);
                swap(nums,i,index);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
