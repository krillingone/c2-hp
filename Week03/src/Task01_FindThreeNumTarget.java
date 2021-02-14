import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task01_FindThreeNumTarget {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists1 = threeSum(nums1, 0);
        System.out.println(Arrays.toString(lists1.toArray()));

        System.out.println("============================================");

        int[] nums2 = {};
        List<List<Integer>> lists2 = threeSum(nums2, 5);
        System.out.println(Arrays.toString(lists2.toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 空组返空结果
        if (nums == null) return result;
        // 数量不足就返空
        int len = nums.length;
        if (len < 3) return result;

        // 简简单单排个序
        Arrays.sort(nums);

        for (int i = 0; i < len-2; i++) {
            // 排过序，如果i大于target，那么L,R都在他的右边肯定更大
            if (nums[i] > target) break;

            // 两个i相同，直接跳
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // 左右指针
            int L = i+1;
            int R = len-1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));

                    // 去重
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++;    // 左指针右移，找个大点的数
                else if (sum > 0) R--;    // 右指针左移，找个小点的数
            }
        }

        return result;
    }
}