import java.util.Scanner;

public class test {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();
       int dis = 0, max = 0;
       for(int i = 0; i < s.length(); i++){
           for(int j = i+1; j < s.length(); j++){
               if(s.charAt(i) == s.charAt(j)){
                   dis = j-i -1;
                   int m = 1;
                   while (m <= dis && j+m < s.length()){
                       if (s.charAt(i + m) != s.charAt(j + m)){
                           break;
                       }
                       m++;
                   }
                   if(m-1 == dis && j + dis <s.length())
                       max = Math.max(2*(dis+1),max);
               }
           }
       }
       System.out.println(max);
   }
}
