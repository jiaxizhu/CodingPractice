import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-04-27 10:25
 */
public class Day4027 {
    /**
     * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = subsets(nums);

    }




    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(nums,0,list,res);
        return list;
    }
    private static void helper(int[] nums, int level, List<List<Integer>> list, List<Integer> res) {
        if (level == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        helper(nums,level + 1, list, res);
        res.add(nums[level]);
        helper(nums,level + 1, list, res);
        res.remove(res.size() - 1);
    }
}