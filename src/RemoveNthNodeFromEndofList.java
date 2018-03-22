import java.util.Scanner;

public class RemoveNthNodeFromEndofList {
 /*   //two pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        ListNode result = new ListNode(0);
        result.next = head;
        int len = 1;
        while (tmp.next != null){
            len ++;
            tmp = tmp.next;
        }
        int rmnum = len - n;
        tmp = result;
        while ((rmnum--) > 0)
            tmp = tmp.next;
        tmp.next = tmp.next.next;
        return result.next;
    }*/
    // one pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode first = result, second = result;
        while ((n--) > 0 )
            second = second.next;
        while (second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return result.next;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = sc.nextInt();
        ListNode tmp = new ListNode(sc.nextInt());
        ListNode notelist = tmp;
        for(int i = 1; i < len; i++) {
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        RemoveNthNodeFromEndofList sl = new RemoveNthNodeFromEndofList();
        ListNode result = sl.removeNthFromEnd(notelist, n);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
