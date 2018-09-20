package BreadthFirstSearch;

/*
We are given a binary tree (with root node root), a target node, and an integer value K.

        Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



        Example 1:

        Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

        Output: [7,4,1]

        Explanation:
        The nodes that are a distance 2 from the target node (with value 5)
        have values 7, 4, and 1.
                  3
               /     \
              5      1
            /  \   /   \
           6   2  0    8
             /  \
            7   4
*/


import Tree.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i < str.length; i+=2){
            TreeNode tmp = q.poll();
            if(!str[i].equals("null")) {
                tmp.left = new TreeNode(Integer.parseInt(str[i]));
                q.add(tmp.left);
            }
            if(!str[i+1].equals("null")){
                tmp.right = new TreeNode(Integer.parseInt(str[i+1]));
                q.add(tmp.right);
            }
        }
       // distanceK(root);
    }
}
