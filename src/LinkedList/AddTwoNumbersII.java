/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/

package LinkedList;
import Base.ListNode;

import java.util.Scanner;
import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        ListNode node = null, next = null;
        ListNode tmp = l1;
        int over = 0, sum;
        while (tmp!=null){
            s1.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = l2;
        while (tmp != null){
            s2.push(tmp.val);
            tmp = tmp.next;
        }
        while (!s1.empty() || !s2.empty()){
            if(!s1.empty() && !s2.empty())
                sum = s1.pop()+s2.pop()+over;
            else if(!s1.empty())
                sum = s1.pop()+over;
            else
                sum = s2.pop()+over;

            node = new ListNode(sum %10);
            over = sum/10;
            node.next = next;
            next = node;
        }
        if(over != 0 ){
            node = new ListNode(over);
            node.next = next;
        }

    return node;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt();
        ListNode l1 = new ListNode(sc.nextInt());
        ListNode tmp = l1;
        for(int i = 1; i < n1; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        ListNode l2 = new ListNode(sc.nextInt());
        tmp = l2;
        for(int i = 1; i < n2; i++){
            tmp.next = new ListNode(sc.nextInt());
            tmp = tmp.next;
        }
        AddTwoNumbersII sl = new AddTwoNumbersII();
        sl.addTwoNumbers(l1, l2);

    }

}
