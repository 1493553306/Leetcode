package LinkedList;
import Base.ListNode;
import java.util.Scanner;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.*/

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode tmp1 = head, tmp2 = head;
        while (tmp1 != null && tmp2 != null){
            tmp1 = tmp1.next;
            if(tmp2.next != null){
                tmp2 = tmp2.next.next;
                if(tmp1 == tmp2 && tmp1 != null){
                    tmp2 = head;
                    while (tmp1 != tmp2){
                        tmp1 = tmp1.next;
                        tmp2 = tmp2.next;
                    }
                    return tmp1;

                }
            }
        }
    return null;
    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    ListNode head = new ListNode(sc.nextInt()), tmp = head;
    for(int i  = 1; i < len; i++){
        tmp.next = new ListNode(sc.nextInt());
        tmp = tmp.next ;
    }
    LinkedListCycleII sl = new LinkedListCycleII();
    sl.detectCycle(head);
}

}
