import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void savePermutations(int[] nums, List<List<Integer>> allPermutations) {
        List<Integer> permutations = new ArrayList<>();
        for (int num : nums) {
            permutations.add(num);
        }
        allPermutations.add(permutations);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void helper(int[] nums, int idx, List<List<Integer>> allPermutations) {
        if (idx == nums.length) {
            savePermutations(nums, allPermutations);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            helper(nums, idx + 1, allPermutations);
            swap(nums, i, idx);
        }
    }

    // Recursion function to find all permutation combinations of given numbers
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        helper(nums, 0, allPermutations);
        return allPermutations;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = findPermutations(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}