package DivideandConquer;

import Base.ListNode;
import java.util.*;

public class MergeKSortedLists {
/*    public Base.ListNode mergeKLists(Base.ListNode[] lists) {
        Base.ListNode result = new Base.ListNode(-1);
        Base.ListNode tmp = result;
        int num = lists.length, leftnum = lists.length;
        if (lists.length == 0)
            return result.next;
        if (lists.length == 1) {
            result.next = lists[0];
            return result.next;
        }
        while (leftnum > 1) {
            leftnum = lists.length;
            int min = -1, index = 0, j = 0;
            for (int i = 0; i < num; i++) {
                if (lists[i] == null)
                    leftnum--;
                if (lists[i] != null) {
                    min = lists[i].val;
                    index = i;
                    j = i + 1;
                    break;
                }
            }
            for (int z = j; z < num; z++) {
                if (lists[z] == null)
                    leftnum--;
                if (lists[z] != null && lists[z].val < min) {
                    min = lists[z].val;
                    index = z;
                }
            }
            if(lists[index]!= null){
                tmp.next = lists[index];
                tmp = tmp.next;
                lists[index] = lists[index].next;
            }
        }
        for (int i = 0; i < num; i++)
            if (lists[i] != null)
                tmp.next = lists[i];
        return result.next;
    }*/
/*方法一*/
/*public ListNode mergeKLists(ListNode[] lists) {
    MergeTwoSortedLists sl = new MergeTwoSortedLists();
    int len = lists.length;
    if (lists.length == 0)
        return null;
    if (lists.length == 1)
        return lists[0];
    while (len >1){
        int mid = (len+1)/2;
        for(int i = 0; i < len/2; i++)
            lists[i] = sl.mergeTwoLists(lists[i],lists[i+mid]);
        len = mid;
    }
    return lists[0];
}*/

/*方法二*/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int len = sc.nextInt();
        ListNode[] lists = new ListNode[k];
        for(int i = 0; i < k; i++){
            lists[i] = new ListNode(sc.nextInt());
            ListNode tmp = lists[i];
            for(int j = 0; j< len-1; j++){
                tmp.next = new ListNode(sc.nextInt());
                tmp = tmp.next;
            }
        }
        MergeKSortedLists sl = new MergeKSortedLists();
        sl.mergeKLists(lists);
    }
}
