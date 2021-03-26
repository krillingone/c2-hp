import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Task04_maxListInSlide {

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, 3, -3, 5, 3, 6, 7};
        int[] nums = {1, 3, 1, 1, 1, 1};
        int k = 3;
        System.out.println(Arrays.toString(solution(nums, k)));
    }

    public static int[] solution(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        // 0 -> k-1,未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();

        // k -> len-1,窗口
        for(int i = k; i < nums.length; i++) {
            // 去重
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            // 不能用<= 去重，不然多个小于前面最大的结果出现错误
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }

        return result;
    }
}
