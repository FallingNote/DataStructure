public class BinarySearch {
    public static int[] searchRange(int[] nums, int target) {
        int i = 0,j = nums.length;
        int[] res = {-1,-1};
        while(i < j){
            int m = (i + j) >>> 1;
            if(nums[m] > target){
                j = m;
            }
            else if(nums[m] < target){
                i = m + 1;
            }
            else{
                int a = m;
                int b = m;
                while(nums[a - 1] == target){
                    a--;
                }
                while(nums[b + 1] == target){
                    b++;
                }
                res[0] = a;
                res[1] = b;
                return res;
            }
        }
        return res;
    }
}
