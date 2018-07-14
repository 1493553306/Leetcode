package LinkedList;
import Base.ListNode;
import java.util.Scanner;

/*Given a linked list, determine if it has a cycle in it.*/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode tmp1, tmp2;
        if(head == null) return false;
        tmp1 = head;
        tmp2 = head;
        while (tmp1 != null && tmp2 != null)
        {
            tmp1 = tmp1.next;
            if(tmp2.next != null) {
                tmp2 = tmp2.next.next;
                if (tmp1 == tmp2 && tmp1 != null)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt()), tmp = head;
        for(int i  = 1; i < len; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next ;
        }
        LinkedListCycle sl = new LinkedListCycle();
        sl.hasCycle(head);
    }
}
