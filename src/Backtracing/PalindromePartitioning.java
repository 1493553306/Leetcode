package Backtracing;

import java.util.*;
//131 problem
//Palindrome Partitioning
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//[
//  ["aa","b"],
//  ["a","a","b"]
//]

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        bchelper(result, new LinkedList<>(), s);
        return result;
    }
    public static void bchelper(List<List<String>>result, List<String>mem, String s){
        if(s.length() == 0)
            result.add(new LinkedList<>(mem));
        else {
            for(int i = 0; i < s.length(); i++){
                if(isValide(s.substring(0, i+1))){
                    mem.add(s.substring(0, i+1));
                    bchelper(result, mem, s.substring(i+1));
                    mem.remove(mem.size()-1);
                }
            }
        }
    }
    public static boolean isValide(String s){
        int start = 0, end = s.length()-1;
        while (start< end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        partition(s);
    }
}
