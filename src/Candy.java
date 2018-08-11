import java.util.Arrays;
import java.util.Scanner;

public class Candy {
    public static int candy(int[] ratings) {
        int sum = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        for(int i = ratings.length-2; i >=0; i--){
            if(ratings[i] > ratings[i+1] )
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
        }
        for(int candy : candies)
            sum += candy;
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        if (in.hasNextLine()) {
            str = in.nextLine();
        }
        String[] s = str.split(" ");
        int[] score = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            score[i] = Integer.parseInt(s[i]);
        }
        System.out.println(candy(score));
    }
}
