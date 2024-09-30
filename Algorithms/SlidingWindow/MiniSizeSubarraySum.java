public class MiniSizeSubarraySum {

    public static long minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int len = 0;
        long sum = 0;
        int windowStart = 0;
        int windowEnd = 0;

        while(windowEnd < nums.length){
            sum += nums[windowEnd];

            while(sum >= target){
                len = windowEnd - windowStart + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[windowStart];
                windowStart++;
            }

            windowEnd++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String rags[]){
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }
}
