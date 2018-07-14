/*你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。
你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要
自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混
合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来
计算出最少需要购买几种颜色的颜料？*/
package Base;
import java.util.*;
public class Xor {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = scanner.nextInt();
            }
            for (int i = length - 1; i > 0; i--) {
                Arrays.sort(nums, 0, i+1);
                for (int j = i - 1; j >= 0; j--) {
                    if ((nums[i] ^ nums[j]) < nums[j]) {
                        nums[j] ^= nums[i];
                    }
                }
            }
            int count;
            for (count = 0; nums[count] == 0; count++) ;
            System.out.println(length - count);
    }
}
