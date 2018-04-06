import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*采取的是自底向上的求解过程:
  1. 选出根结点后分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合;根的右子树有若干种，它们组成右子树集合。
  2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
  3. 最后，把根结点放入链表中。*/
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        if(n==0) return result;
        result = helper(1,n);
        return result;
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> tmp = new LinkedList<TreeNode>();
        if(start == end){
            tmp.add(new TreeNode(start));
            return tmp;
        }
        if(start > end){
            tmp.add(null);
            return tmp;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftChild = helper(start, i-1);
            List<TreeNode> rightChild = helper(i+1, end);
            for (TreeNode left: leftChild){
                for(TreeNode right: rightChild){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    tmp.add(root);
                }
            }
        }
        return tmp;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UniqueBinarySearchTrees2 sl = new UniqueBinarySearchTrees2();
        sl.generateTrees(n);
    }

}
