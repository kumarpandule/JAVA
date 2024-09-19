
public class MergeSort {
    public static void conquer(int arr[], int staticIdx, int mid, int endingIdx){
        int merge[] = new int[endingIdx - staticIdx + 1];

        int idx1 = staticIdx;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= endingIdx){
            if(arr[idx1] <= arr[idx2]){
                merge[x] = arr[idx1];
                x++;
                idx1++;
            }else{
                merge[x] = arr[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1 <= mid){
            merge[x] = arr[idx1];
            x++;
            idx1++;
        }

        while(idx2 <= endingIdx){
            merge[x] = arr[idx2];
            x++;
            idx2++;
        }

        for(int i=0, j=staticIdx; i<merge.length; i++, j++){
            arr[j] = merge[i];
        }
    }

    public static void divide(int arr[], int staticIdx, int endingIdx){
        if(staticIdx >= endingIdx){
            return;
        }
        int mid = staticIdx + (endingIdx - staticIdx)/2;
        divide(arr, staticIdx, mid);
        divide(arr, mid + 1, endingIdx);
        conquer(arr, staticIdx, mid, endingIdx);
    }
    public static void main(String args[]){
        int arr[] = {5,2,3,1};
        divide(arr, 0, arr.length - 1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
