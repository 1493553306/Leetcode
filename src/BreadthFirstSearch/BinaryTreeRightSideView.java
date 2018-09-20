package BreadthFirstSearch;
import Tree.TreeNode;
import java.util.*;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

        Example:

        Input: [1,2,3,null,5,null,4]
        Output: [1, 3, 4]
        Explanation:

          1            <---
        /   \
       2     3         <---
       \     \
        5     4        <---
*/


public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result  = new LinkedList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            TreeNode tmp = null;
            for(int i = 0; i < size; i++){
                tmp = q.poll();
                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null)
                    q.add(tmp.right);
            }
            result.add(tmp.val);
        }
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
        rightSideView(root);
    }


}
