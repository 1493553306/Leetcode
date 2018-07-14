/*Given a sorted linked list, delete all duplicates such that each element appear only once.

        Example 1:

        Input: 1->1->2
        Output: 1->2
        Example 2:

        Input: 1->1->2->3->3
        Output: 1->2->3*/
package LinkedList;
import Base.ListNode;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, tmp = head;
        while (tmp != null ){
            tmp = tmp.next;
            while (tmp != null && tmp.val == pre.val)
                tmp = tmp.next;
            pre.next = tmp;
            pre = tmp;
        }
        return head;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode tmp = head;
        for(int i = 1; i < n; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        RemoveDuplicatesFromSortedList sl = new RemoveDuplicatesFromSortedList();
        sl.deleteDuplicates(head);
    }
}
