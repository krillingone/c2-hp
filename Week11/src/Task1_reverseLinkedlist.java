public class Task1_reverseLinkedlist {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        ListNode cur = reverse(l1);
        while (cur != null) {
            System.out.print(cur.val + "=>");
            cur = cur.next;
        }
    }

    /**
     * 1->2->3->null
     * 所以直接把将头左移向前就得了
     * @param node origin linkedList head
     * @return
     */
    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
