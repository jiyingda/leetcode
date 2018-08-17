public class TwoNumbers {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < i; j++){
                    if((nums[i] + nums[j]) == target){
                        return new int[]{j,i};
                    }
                }

        }
        return null;
    }
    public static void main(String... args){
        int[] nums = new int[]{-3,4,3,90};
        int target = 0;
        int[] rr = twoSum(nums, target);
        System.out.println(rr[0] + "===" + rr[1]);
    }
}
