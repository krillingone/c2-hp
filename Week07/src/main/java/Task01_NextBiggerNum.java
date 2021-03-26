import java.util.*;

public class Task01_NextBiggerNum {
    public static void main(String[] args) {
        int[] l1 = {4, 1, 2};
        int[] l2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(solution(l1, l2)));
    }

    public static int[] solution(int[] list1, int[] list2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list2.length; i++) {
            while (!stack.isEmpty() && stack.peekLast() < list2[i]) {
                // 添加的是（被替换的数，替换的数），单调栈所以替换的数肯定大一点，到时候就可以通过键来找比它大的
                // 艹，说的对应位置是数对应，不是index
                map.put(stack.removeLast(), list2[i]);
            }
            stack.addLast(list2[i]);
        }

        int[] result = new int[list1.length];
        for (int i = 0; i < list1.length; i++) {
            result[i] = map.getOrDefault(list1[i], -1);
        }
        return result;
    }
}
