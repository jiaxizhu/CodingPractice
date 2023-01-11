package code;

/**
 * @author zhujiaxi01
 * @date 2022-11-14 15:08
 */
public class ClassicBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,5,7,9};
        System.out.println(helper(arr,3));

    }
    private static int helper(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
