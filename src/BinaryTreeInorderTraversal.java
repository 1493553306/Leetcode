import java.time.temporal.Temporal;
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
       if(root!= null) q.add(root);
       TreeNode tmp = root;
       while (!q.isEmpty()){
           while (tmp!= null && tmp.left != null){
               q.add(tmp.left);
               tmp = tmp.left;
           }
           tmp = q.pop();
           result.add(tmp.val);
           tmp = tmp.right;
           if(tmp != null)
               q.add(tmp);
       }
       System.out.print('a');
       return result;
   }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BinaryTreeInorderTraversal sl = new BinaryTreeInorderTraversal();
        int len = sc.nextInt(), index = 1;
        char[] tree = new char[len];
        TreeNode root, tmp;
        Queue<TreeNode> q;
        for(int i = 0; i < len; i++)
            tree[i] = sc.next().charAt(0);
        root = new TreeNode(tree[0]-'0');
        q= new LinkedList<TreeNode>();
        q.add(root);
        while (index < tree.length){
            tmp = q.poll();
            if (tree[index] != '#')
            {
                tmp.left = new TreeNode(tree[index]-'0');
                q.add(tmp.left);
            }
            index++;
            if(index < tree.length && tree[index] != '#')
            {
                tmp.right = new TreeNode(tree[index] -'0');
                q.add(tmp.right);
            }
            index++;
        }
        sl.inorderTraversal(root);

    }
}
