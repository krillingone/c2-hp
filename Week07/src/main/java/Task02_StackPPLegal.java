import java.util.ArrayDeque;
import java.util.Deque;

public class Task02_StackPPLegal {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
//        int[] pop = {4, 5, 3, 2, 1};
        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(solution(push, pop));
    }

    /**
     * push指针一个一个往前push，当前栈顶与pop当前指针位置相同就pop一个
     * 最后要是两个指针都过了数组终点，那就是能正常pp
     * @param push
     * @param pop
     * @return
     */
    public static boolean solution(int[] push, int[] pop) {
        int pushLen = push.length;
        int popLen = pop.length;
        int i = 0, j = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (i = 0; i < pushLen; i++) {
            stack.addFirst(push[i]);
            while (!stack.isEmpty() && stack.peekFirst() == pop[j]) {
                stack.removeFirst();
                j++;
            }
        }
        if (i == pushLen && j == popLen) {
            return true;
        } else {
            return false;
        }
    }
}
