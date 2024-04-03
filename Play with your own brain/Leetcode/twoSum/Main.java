
/* Description */

// TWO SUM

// public class Main {

// public static void main(String[] args) {

// int[] nums = { 1, 2, 3 };
// int target = 4;

// int[] result = solution(nums, target);

// if (result != null) {
// System.out.println("Index 1: " + result[0] + ", Index 2: " + result[1]);
// } else {
// System.out.println("No two numbers add up to the target.");
// }
// }

// public static int[] solution(int[] nums, int target) {
// int[] result = new int[2];

// for (int i = 0; i < nums.length; i++) {
// for (int j = i + 1; j < nums.length; j++) {
// if (nums[i] + nums[j] == target) {

// // add the index pair of indicators to result
// result = new int[] { i, j };
// return result;
// }
// }
// }
// return result;
// }
// }

/* More Sum */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 8, 16 };
        int target = 3;
        List<List<Integer>> result = sumCombination(nums, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> sumCombination(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain,
            int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}