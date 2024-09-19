public class QuickSort {

    public static int partition(int nums[], int low, int high){
        int pivot = nums[high];
        int i = low - 1;

         for(int j=low; j<high; j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
         }

         i++;
         int temp = nums[i];
         nums[i] = pivot;
         nums[high] = temp;

        return i;
    }

    public static void quickSort(int nums[], int low, int high){
        if(low < high){
            int pivotIdx = partition(nums, low, high);

            // For lower vlaue indises
            quickSort(nums, low, pivotIdx - 1);
            // for Higher value Indises
            quickSort(nums, pivotIdx + 1, high);
        }
    }

    public static void main(String args[]){
        int nums[] = {4,3,5,2,1};
        int size = nums.length - 1;
        quickSort(nums, 0, size);

        for(int i=0; i<size; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
