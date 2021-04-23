public class Task3_pali {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l2_ = new ListNode(2);
        ListNode l1_ = new ListNode(1);

        l1.next = l2;
        l2.next=l2_;
        l2_.next=l1_;

//        System.out.println(solution(l1));
        System.out.println(isPalindrome(l1));
    }

    public static boolean solution(ListNode node) {
        ListNode half = getHalfNode(node);
        ListNode l1 = Task1_reverseLinkedlist.reverse(half);
        ListNode l2 = node;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    /**
     * 快慢指针，一个一步，一个两步，慢的那个就在中间
     * @param node
     * @return
     */
    public static ListNode getHalfNode(ListNode node) {
        ListNode fast = node, slow = node;
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * lc:mesmerizeBy带佬的正反哈希
     * 看不懂
     * 回文数反转之后不变，一个正向计算哈希值，一个反向计算哈希值，比较反转之前和反转之后的哈希值是否相等
     * 真是妙蛙种子吃着妙脆角妙进了米奇妙妙屋 妙到家了
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode t=head;
        int base = 11, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        while(t!=null){
            left = (int) (((long) left * base + t.val) % mod);
            right = (int) ((right + (long) mul * t.val) % mod);
            mul = (int) ((long) mul * base % mod);
            t=t.next;
        }
        return left==right;
    }
}
