package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*n只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果
到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。

输入描述:
每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。

输出描述:
输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。

示例1
输入
4
7 15 9 5

输出
 3*/

public class FenPingGuo {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        String[] strings = str.trim().split(" ");
        int[] num = new int[len];
        int sum = 0 , avg = 0, result = 0, diff = 0;
        for(int i = 0; i < len; i++){
            num[i] = Integer.parseInt(strings[i]);
            sum += num[i];
        }
        if(sum % len != 0){                    //如果不能均分，肯定方案不存在
            result = -1;
            System.out.println(result);
            return;
        }
        avg = sum / len;
        for(int i = 0; i < len; i++){
            diff = num[i] - avg;
            if(diff > 0 && diff % 2 == 0){
                result += diff /2;             //利用少于均值数，统计要分几次
            }
            else if(diff <=0 && (-diff) %2 == 0){

            }
            else{
                result = -1;                  //如果与均值的差不是2的倍数，方案肯定不存在
                System.out.println(result);
                return;
            }
        }
        System.out.println(result);
        return;
    }
}
