import java.util.Scanner;

public class MergeKSortedLists {
/*    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
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
public ListNode mergeKLists(ListNode[] lists) {
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
