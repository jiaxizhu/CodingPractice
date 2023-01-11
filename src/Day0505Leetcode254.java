import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-05-05 17:21
 */
public class Day0505Leetcode254 {
    /**
     * 整数可以被看作是其因子的乘积。
     *
     * 例如：
     *
     * 8 = 2 x 2 x 2;
     *   = 2 x 4.
     * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
     *
     * 注意：
     *
     * 你可以假定 n 为永远为正数。
     * 因子必须大于 1 并且小于 n。
     * 示例 1：
     *
     * 输入: 1
     * 输出: []
     * 示例 2：
     *
     * 输入: 37
     * 输出: []
     * 示例 3：
     *
     * 输入: 12
     * 输出:
     * [
     *   [2, 6],
     *   [2, 2, 3],
     *   [3, 4]
     * ]
     * 示例 4:
     *
     * 输入: 32
     * 输出:
     * [
     *   [2, 16],
     *   [2, 2, 8],
     *   [2, 2, 2, 4],
     *   [2, 2, 2, 2, 2],
     *   [2, 4, 4],
     *   [4, 8]
     * ]
     *
     */
    public static void main(String[] args) {
        List<List<Integer>> factors = getFactors(32);
        List<List<Integer>> factors1 = getFactors1(32);
        int i = 0;

    }
    public static List<List<Integer>> getFactors(int n) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (n == 1) {
            return list;
        }
        helper(res,list,n,2);
        return list;
    }
    private static void helper(List<Integer> res, List<List<Integer>> list, int n, int start) {
        if (n == 1) {
            return;
        }
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                res.add(i);
                res.add(n / i);
                list.add(new ArrayList<>(res));
                res.remove(res.size() - 1);
                helper(res,list,n / i,i);
                res.remove(res.size() - 1);
            }
        }
    }
    public static List<List<Integer>> getFactors1(int n) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            return list;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                nums.add(i);
            }
        }
        helper1(nums,res,list,n,0);
        return list;
    }
    private static void helper1(List<Integer> nums, List<Integer> res, List<List<Integer>> list, int n, int index) {
        if (n == 1) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (n % nums.get(i) == 0) {
                res.add(nums.get(i));
                helper1(nums,res,list,n / nums.get(i), i);
                res.remove(res.size() - 1);
            }
        }
    }
}
