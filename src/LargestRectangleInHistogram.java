import java.util.*;

public class LargestRectangleInHistogram {
    /*时间复杂度为O(n^2), 构建二维数据，横坐标为heights[]，纵坐标arr[]为heights[]里面出现过的高度。基本思想是分别统计以arr[i]为最大高度，可以获得的最大面积*/
    /*超时*/
    /*public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        Set<Integer> tmp = new HashSet<Integer>();
        for(int i = 0; i < heights.length; i++)
            tmp.add(heights[i]);
        Integer[] arr = new Integer[tmp.size()];
        int[] intarr = new int[tmp.size()];
        tmp.toArray(arr);
        for(int i = 0; i < tmp.size(); i++)
            intarr[i] = arr[i].intValue();

        int[][] result = new int[tmp.size()][heights.length];
        for(int i = 0; i < intarr.length; i++) {
            result[i][0] = heights[0] >= intarr[i] ? intarr[i] : 0;
            maxarea = result[i][0] > maxarea ? result[i][0] : maxarea;
        }
        for(int i = 0; i < intarr.length; i++){
            for(int j = 1; j < heights.length; j++){
                result[i][j] = heights[j] >= intarr[i] ? intarr[i] + result[i][j-1] :0;
                maxarea = result[i][j] > maxarea ? result[i][j] : maxarea;
            }
        }
        return maxarea;
    }*/

  /*  时间复杂度O(n)。维护一个栈，栈中保存的是下标，栈中下标对应的高度为非降型。当前下标对应的高度 < 栈顶元素对应的高度，栈顶元素出栈，
    并计算面积=（当前元素-栈顶元素）*出栈元素对应的高度。最后一个while循环是确保最终所有元素都出栈。*/
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int maxarea = -1, index;
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        for(int i = 0; i < heights.length; i++) {
            if (s.peek() == -1 ) s.push(i);
            else if(heights[i] >= heights[s.peek()]) s.push(i);
            else {
                while (s.peek() != -1 && heights[i] < heights[s.peek()]){
                    index = s.pop();
                    maxarea = maxarea > (i - s.peek() -1)*heights[index] ? maxarea : (i-s.peek()-1)*heights[index];
                }
                s.push(i);
            }
        }
        while (s.peek() != -1){
            index = s.pop();
            maxarea = maxarea > (heights.length - s.peek() -1)*heights[index] ? maxarea : (heights.length-s.peek()-1)*heights[index];
        }
        return maxarea;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] heights = new int[len];
        for(int i = 0; i < len; i++)
            heights[i] = sc.nextInt();
        LargestRectangleInHistogram sl = new LargestRectangleInHistogram();
        sl.largestRectangleArea(heights);
    }
}
