public class ConatinerWithHighWater {

    public static int maxArea(int[] height){
        int maxHeight = 0;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while(leftPointer < rightPointer){
            int width = rightPointer - leftPointer;
            int minHeight = Math.min(height[leftPointer], height[rightPointer]);

            int currentArea = width * minHeight;
            maxHeight = Math.max(maxHeight, currentArea);

            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        return maxHeight;
    }
    public static void main(String args[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}