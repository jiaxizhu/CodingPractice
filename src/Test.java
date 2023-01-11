import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhujiaxi01
 * @date 2022-09-06 17:42
 */
public class Test {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,3};
//        int target = 3;
//        System.out.println(helper(arr,target));
//        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
//        int[][] image = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        rotate(image);
//        for (int i = 0; i < image.length; i++) {
//            for (int j = 0; j < image[0].length; j++) {
//                System.out.println(image[i][j]);
//            }
//        }
//        System.out.println(lengthOfLIS(nums));
//        String s = "babad";
//        System.out.println(findLongest(s));

//        System.out.println(validAddress("256.256.256.256"));
    }
    private static int helper(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > arr[right]) {
                if (target < arr[mid] && target >= arr[left]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if (target <= arr[right] && target > arr[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    private static String findLongest(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String longest = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            String one = helper1(s,i,i);
            if (one.length() > longest.length()) {
                longest = one;
            }
            String two = helper1(s,i,i + 1);
            if (two.length() > longest.length()) {
                longest = two;
            }
        }
        return longest;
    }
    private static String helper1(String s, int left, int right) {
        if (left > right) {
            return "";
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        while (left < right && top < down) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top; i < down; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down; i > top; i--) {
                result.add(matrix[i][left]);
            }
        }
        if (left > right || top > down) {
            return result;
        }
        if (left == right) {
            for (int i = top; i <= down; i++) {
                result.add(matrix[i][left]);
            }
        }
        else {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
        }
        return result;
    }
//int[] dp   dp represents
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            count = Math.max(count,dp[i]);
        }
        return count;
    }

    //arr = [1,2,3] 1 3 2      2 3 1   3 1 2  3 2 1
    public static void nextPermutation(int[] num) {
        int temp = -1;
        for (int i = num.length - 2; i >= 0 ; i--) {
            if (num[i] < num[i + 1]) {
                temp = i;
                break;
            }
        }
        if (temp == -1) {
            reverse(num,0,num.length - 1);
            return;
        }
        int index = -1;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] > num[temp]) {
                index = i;
                break;
            }
        }
        swap(num,temp,index);
        reverse(num,temp + 1, num.length - 1);
    }
    private static void reverse(int[] num, int left, int right) {
        while (left < right) {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
    private static void rotate(int[][] image) {
            for (int i = 0; i < image.length / 2; i++) {
                for (int j = 0; j < image[0].length; j++) {
                    int temp = image[i][j];
                    image[i][j] = image[image.length - 1 - i][j];
                    image[image.length - 1 - i][j] = temp;
                }
            }
            for (int i = 0; i < image.length; i++) {
                for (int j = i + 1; j < image[0].length; j++) {
                    int r = image[i][j];
                    image[i][j] = image[j][i];
                    image[j][i] = r;
                }
            }
    }


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     *  
     *
     * 提示：
     *
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     *  
     *
     */

    public static int findResult(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int num = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
            while (left <= i && num >= target) {
                res = Math.min(res, i - left + 1);
                num -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
     *
     * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
     *
     * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
     *
     * 1 <= xi.length <= 4
     * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
     * 在 xi 中允许前导零。
     * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：queryIP = "172.16.254.1"
     * 输出："IPv4"
     * 解释：有效的 IPv4 地址，返回 "IPv4"
     * 示例 2：
     *
     * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出："IPv6"
     * 解释：有效的 IPv6 地址，返回 "IPv6"
     * 示例 3：
     *
     * 输入：queryIP = "256.256.256.256"
     * 输出："Neither"
     * 解释：既不是 IPv4 地址，又不是 IPv6 地址
     *
     */


    public static String validAddress(String ip) {
        if (ip.indexOf(".") >= 0 && isIPv4(ip)) {
            return "IPv4";
        }
        if (ip.indexOf(":") >= 0 && isIPv6(ip)) {
            return "IPv6";
        }
        return "Neither";
    }
    public static boolean isIPv4(String ip) {
        String[] str = ip.split("\\.",-1);
        if (str.length != 4) {
            return false;
        }
        for (String s : str) {
            if (s.length() > 3 || s.length() == 0) {
                return false;
            }
            if (s.charAt(0) == '0' && s.length() != 1) {
                return false;
            }
            int ans = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!Character.isDigit(c)) {
                    return false;
                }
                ans = ans * 10 + c - '0';
            }
            if (ans > 255) {
                return false;
            }
        }
        return  true;
    }

    public static boolean isIPv6(String ip) {
        String[] str = ip.split("\\:",-1);
        if (str.length != 8) {
            return false;
        }
        for (String s : str) {
            if (s.length() > 4 || s.length() == 0) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c) && !(Character.toLowerCase(c) >= 'a' && Character.toLowerCase(c) <= 'f')) {
                    return false;
                }
            }
        }
        return true;

    }

}
