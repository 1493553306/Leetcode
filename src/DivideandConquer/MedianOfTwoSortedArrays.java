package DivideandConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int startIndex1 = 0, startIndex2 =0;
        int loop = (nums1.length + nums2.length)/2, times = 0;
        double result;
        while (times <= loop){
            if(startIndex1 <= nums1.length -1 && startIndex2 <= nums2.length-1){
                if (nums1[startIndex1] < nums2[startIndex2]){
                    list.add(nums1[startIndex1++]);
                }
                else {
                    list.add(nums2[startIndex2++]);
                }
            }
            else if(startIndex1 > nums1.length-1){
                list.add(nums2[startIndex2++]);
            }
            else{
                list.add(nums1[startIndex1++]);
            }

            times++;
        }
        if((nums1.length+nums2.length)%2 == 0)
            result = (double)(list.get(list.size()-1)+list.get(list.size()-2))/2;
        else
            result = (double)(list.get(list.size()-1));
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt(), len2 = sc.nextInt();
        int[] nums1 = new int[len1], nums2 = new int[len2];
        for(int i = 0; i < len1; i++)
            nums1[i] = sc.nextInt();
        for(int j = 0; j < len2; j++)
            nums2[j] = sc.nextInt();
        MedianOfTwoSortedArrays sl = new MedianOfTwoSortedArrays();
        sl.findMedianSortedArrays(nums1,nums2);
    }
}
