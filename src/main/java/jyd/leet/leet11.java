package jyd.leet;

public class leet11 {

    public static void main(String... args){
        int[] he = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(he));
    }


    /*public static int maxArea(int[] height) {
        int max = 0;
        for(int i = height.length - 1; i > 0; i--){
            for(int j = 0; j < i + 1; j++){
                int tmp = Integer.min(height[i], height[j]) * (i - j);
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        return max;
    }*/
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
