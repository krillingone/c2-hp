import java.util.HashMap;
import java.util.Map;

public class Task03_SumOfUniqueNum {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2};
        int[] nums2 = {1, 1, 1, 1};
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result=0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                result += key;
            }
        }
        return result;
    }
}
