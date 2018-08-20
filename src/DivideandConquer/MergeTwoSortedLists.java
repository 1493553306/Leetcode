package DivideandConquer;

import Base.ListNode;

import java.util.Scanner;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 == null ? l2:  l1);
        return result.next;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        ListNode l1 = new ListNode(sc.nextInt());
        ListNode tmp = l1;
        for(int i = 1; i < n1; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        ListNode l2 = new ListNode(sc.nextInt());
        tmp = l2;
        for(int i =1; i < n2; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        MergeTwoSortedLists sl = new MergeTwoSortedLists();
        sl.mergeTwoLists(l1, l2);
    }
}
