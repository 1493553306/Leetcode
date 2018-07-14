package LinkedList;
import Base.ListNode;
import java.util.Scanner;

/* Write a program to find the node at which the intersection of two singly linked lists begins.
 For example, the following two linked lists:

     A:    a1 → a2
                   ↘
                    c1 → c2 → c3
                   ↗
     B:b1 → b2 → b3
 */
public class IntersectionOfTwoLinkedLists {

   /* public ListNode reverse(ListNode head){
        ListNode reversedHead = null;
        ListNode pnode = head, next = null, pre = null;
        while ( pnode != null){
            next = pnode.next;
            if(next == null)
                reversedHead = pnode;
            pnode.next = pre;
            pre = pnode;
            pnode = next;
        }
        return reversedHead;
    }*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0, diff  = 0;
        ListNode tmp1 = headA, tmp2 = headB;
        while (tmp1 != null){
            tmp1 = tmp1.next;
            len1++;
        }
        while (tmp2 != null){
            tmp2 = tmp2.next;
            len2++;
        }
        diff = len1 - len2;
        if(diff > 0){
            while (diff > 0){
                headA = headA.next;
                diff--;
            }
        }else {
            diff = -diff;
            while (diff > 0){
                headB = headB.next;
                diff--;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt(), len2 = sc.nextInt(), len3 = sc.nextInt();
        ListNode headA = new ListNode(sc.nextInt());
        ListNode headB = null;
        ListNode intersection=null, tmp = headA;
        for(int i = 1; i < len1; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        tmp.next = new ListNode(sc.nextInt());
        tmp = tmp.next;
        intersection = tmp;
        for(int i = 1; i < len2; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }

        headB = new ListNode(sc.nextInt());
        tmp = headB;
        for(int i = 1; i < len3; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        tmp.next = intersection;

        IntersectionOfTwoLinkedLists sl = new IntersectionOfTwoLinkedLists();
        sl.getIntersectionNode(headA, headB);

    }
}
