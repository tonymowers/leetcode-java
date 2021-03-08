package ch.alika.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * see: https://leetcode.com/problems/two-sum/
 */
public class SolutionTwoSum {

  public static int[] twoSumBruteForce(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i])
          return new int[]{i, j};
      }
    }

    throw  new IllegalArgumentException("no twoSum solution");
  }

  public static int[] twoSumHashMap(int[] nums, int target) {

    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numMap.containsKey(complement)) {
        return new int[] {i, numMap.get(complement)};
      }
      numMap.put(nums[i],i);
    }

    throw  new IllegalArgumentException("no twoSum solution");
  }
}
