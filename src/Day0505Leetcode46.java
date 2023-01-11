import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-05-05 21:30
 */
public class Day0505Leetcode46 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,nums,0);
        return list;
    }
    private void helper(List<List<Integer>> list, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            list.add(res);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums,i,index);
            helper(list,nums,index + 1);
            swap(nums,i,index);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1,5},{3,9},{2,9},{5,8},{4,7}};
        Arrays.sort(res,(int[] a, int[] b) -> (a[0] - b[0]));

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
