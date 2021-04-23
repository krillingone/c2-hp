public class Task2_merge {
    public static void main(String[] args) {
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(2);
        ListNode l14=new ListNode(4);

        ListNode l21=new ListNode(1);
        ListNode l23=new ListNode(3);
        ListNode l24=new ListNode(4);

        l11.next=l12;
        l12.next=l14;

        l21.next=l23;
        l23.next=l24;

        ListNode rt = solution(l11, l21);
        ListNode cur = rt;
        while (cur != null) {
            System.out.print(cur.val + "=>");
            cur = cur.next;
        }

    }

    public static ListNode solution(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);    // 临时头
        ListNode cur = head;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        // 哪个空了那就把另外那个后面全部接上去
        cur.next = n1 != null ? n1 : n2;

        return head.next;
    }
}
