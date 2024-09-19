public class Test {

    public static boolean isLarge(int[] nums, int i, int j) {
        String first = Integer.toString(nums[i]);
        String second = Integer.toString(nums[j]);
        String order1 = first + second;
        String order2 = second + first;
        return order1.compareTo(order2) > 0;
    }

    public static String largestNumber(int[] nums) {
        // Bubble sort based on the custom comparison
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!isLarge(nums, i, j)) {
                    // Swap nums[i] and nums[j]
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // Build the largest number from the sorted array
        StringBuilder newStr = new StringBuilder();
        for (int num : nums) {
            newStr.append(num);
        }

        // Handle the case where the result might be "0"
        if (newStr.charAt(0) == '0') {
            return "0";
        }

        return newStr.toString();
    }

    public static boolean isPalindrome(int x){
        if(x <= 9 && x >= 0){
            return true;
        }
        String number = String.valueOf(x);
        System.out.println(number);
        int len = number.length() - 1;
        for(int i=0; i<number.length() / 2; i++){
            if(number.charAt(i) != number.charAt(len - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.print(isPalindrome(x));
    }
}