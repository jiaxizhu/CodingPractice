import java.util.HashMap;

/**
 * @author zhujiaxi01
 * @date 2022-04-28 18:58
 */
public class Day0505Leetcode377 {
    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * 题目数据保证答案符合 32 位整数范围。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * 示例 2：
     *
     * 输入：nums = [9], target = 3
     * 输出：0
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 1000
     * nums 中的所有元素 互不相同
     * 1 <= target <= 1000
     *  
     *
     */
    public static void main(String[] args) {
        int[] res = new int[]{1,2,3};
        System.out.println(combinationSum4(res,4));
        System.out.println(combinationSum5(res,4));
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    public static int combinationSum4(int[] nums, int target) {
        return helper(nums,target);
    }
    private static int helper(int[] nums, int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret += helper(nums,target - nums[i]);
        }
        return ret;
    }
    public static int combinationSum5(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
