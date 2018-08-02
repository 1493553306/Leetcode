package Tree;

import java.util.*;

public class BinaryTreeInorderTraversal {
   /* *//*方法一：中序遍历，最直接的方法是递归*//*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        help(root, result);
        return result;
    }
    public void help(TreeNode root, List<Integer> result){
        if(root!=null){
            if(root.left != null) help(root.left, result);
            result.add(root.val);
            if(root.right != null) help(root.right,result);
        }
    }*/
    /*用栈的思想，只要有左子树，左子树入栈；否则，栈顶元素出栈，并将栈顶元素的右子树入栈（如有有右子树）。下一个要判断的就是右子树*/
   public List<Integer> inorderTraversal(TreeNode root){
       List<Integer> result = new LinkedList<Integer>();
       Stack<TreeNode> q = new Stack<TreeNode>();
       TreeNode cur = root;
       while (cur != null || !q.isEmpty()){
           while (cur!= null ){
               q.add(cur);
               cur = cur.left;
           }
           cur = q.pop();
           result.add(cur.val);
           cur = cur.right;
       }
       System.out.print('a');
       return result;
   }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BinaryTreeInorderTraversal sl = new BinaryTreeInorderTraversal();
        int len = sc.nextInt(), index = 1, var;
        TreeNode root, tmp;
        root = new TreeNode(sc.nextInt());
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);

        while (index < len){
            tmp = q.poll();
            var = sc.nextInt();
            if (var != 0)
            {
                tmp.left = new TreeNode(var);
                q.add(tmp.left);
            }
            index++;
            var = sc.nextInt();
            if(index < len && var != 0)
            {
                tmp.right = new TreeNode(var);
                q.add(tmp.right);
            }
            index++;
        }
        sl.inorderTraversal(root);

    }
}
