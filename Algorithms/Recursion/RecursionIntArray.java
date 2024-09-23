
import java.util.Scanner;

public class RecursionIntArray {
    // Recursion function to check if an array is sorted with strictly increasing order
    public static boolean isArraySorted(int[] nums, int idx){
        if(idx == nums.length - 1){
            return true;
        }
        if(nums[idx] >= nums[idx + 1]){
            return false;
        }
        return isArraySorted(nums, idx + 1);
    }

    public static void main(String args[]){
        int[] nums;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Please enter size of array: ");
            int num = scan.nextInt();
            nums = new int[num];
            System.out.print("Please enter elements of array: ");
            for(int i=0; i<num; i++){
                nums[i] = scan.nextInt();
            }
        }
        System.out.println();
        System.out.print("Check if an array is sorted (Strictly Increasing): " + isArraySorted(nums, 0));
    }
}
