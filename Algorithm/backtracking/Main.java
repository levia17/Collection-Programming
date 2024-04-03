import java.util.ArrayList;
import java.util.List;

/**
 ** @Diagram [https://app.diagrams.net/#G19aisFz8ZdoM-3_w88NjMcc03ibxEhIx7#%7B%22pageId%22%3A%22OhsN6Br1bW_n3V8B0wL3%22%7D]
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 6 };
        int target = 8;
        List<List<Integer>> containerResult = sumCombination(nums, target);
        for (List<Integer> result : containerResult) {
            System.out.println(result);
        }
    }

    public static List<List<Integer>> sumCombination(int[] childArray, int target) {
        List<List<Integer>> containerArray = new ArrayList<>();
        backtrack(containerArray, new ArrayList<>(), target, childArray, 0);
        return containerArray;
    }

    public static void backtrack(
            List<List<Integer>> containerArray,
            List<Integer> tempArray,
            int remain,
            int[] nums,
            int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            containerArray.add(new ArrayList<>(tempArray));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempArray.add(nums[i]);
                backtrack(containerArray, tempArray, remain - nums[i], nums, i);
                tempArray.remove(tempArray.size() - 1);
            }
        }
    }

}