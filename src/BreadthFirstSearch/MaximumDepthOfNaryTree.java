package BreadthFirstSearch;

import java.util.*;

public class MaximumDepthOfNaryTree {
    public static int maxDepth(Node root) {
        if(root == null) return 0;
        int max = 0;
        for(Node child : root.children) max = Math.max(max, maxDepth(child));
        return max + 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> no = new ArrayList<>();
        Node n5 = new Node(5, no);
        Node n6 = new Node(6, no);
        ArrayList<Node> list = new ArrayList<>();
        list.add(n5);
        list.add(n6);
        Node n3 = new Node(3, list);
        Node n2 = new Node(2, no);
        Node n4 = new Node(4, no);
        ArrayList<Node> list2 = new ArrayList<>();
        list2.add(n2);
        list2.add(n3);
        list2.add(n4);
        Node n1 = new Node(1, list2);
        System.out.println(maxDepth(n1));
    }

}
