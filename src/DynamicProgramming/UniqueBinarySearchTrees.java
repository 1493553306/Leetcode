package DynamicProgramming;

import java.util.Scanner;

/*这道题实际上是 Catalan Number卡塔兰数的一个例子,是一道动态规划题。n = 0 时赋为1，因为空树也算一种二叉搜索树；
  那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，所以1乘1还是1。那么n = 2时，由于1和
  2都可以为跟，分别算出来，再把它们加起来即可。
  递推公式为：Cn+1 = C0*Cn + C1*Cn-1 + ... + Cn*C0*/
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] rep = new int[n+1];
        rep[0] = rep[1] = 1;
        for(int i = 2; i < n+1; i++)
            for (int j = 0; j < i; j++)
                rep[i] += rep[j]*rep[i-1-j];
        return rep[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UniqueBinarySearchTrees sl = new UniqueBinarySearchTrees();
        sl.numTrees(n);
    }
}
