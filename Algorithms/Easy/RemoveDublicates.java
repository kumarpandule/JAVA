public class RemoveDublicates {

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        int previousInt = -101;
        for(int i=0; i<nums.length; i++){
           if(previousInt != nums[i]){
              previousInt = nums[i];
              nums[count] = nums[i];
              count++; 
           }
        }
        return count; 
      }
    public static void main(String args[]){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for(int i = 0; i <nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
