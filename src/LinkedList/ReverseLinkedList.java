

/*Reverse a singly linked list.

        Example:

        Input: 1->2->3->4->5->NULL
        Output: 5->4->3->2->1->NULL
        Follow up:

        A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

package LinkedList;
import Base.ListNode;

import java.util.Scanner;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        ReverseLinkedList sl = new ReverseLinkedList();
        sl.reverseList(head);
    }

}
