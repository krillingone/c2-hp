import java.util.LinkedList;

// 约瑟夫环问题：圆圈中最后剩下的数字
public class Task02_Josephus {
    public static void main(String[] args) {
        System.out.println(solution(10, 2));
    }

    /**
     * 通过remove和add给链表转圈圈，m次挪位子后，在庄家位的就得死
     * @param n 人数
     * @param m 喊道几死
     * @return 存活座位
     */
    public static int solution(int n, int m) {
        // init
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        while (list.size() > 1) {
            // 将头放到屁股，m次过后，要死的那个就在头了
            for (int i = 0; i < m - 1; i++) {
                list.add(list.remove());
            }
            // 砍头
            list.remove();
        }
        return list.getFirst();
    }
}
