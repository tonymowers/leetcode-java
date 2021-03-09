package ch.alika.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * see: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

  public static int[] twoSumBruteForce(int[] ints, int target) {

    for (int i = 0; i < ints.length; i++) {
      for (int j = i + 1; j < ints.length; j++) {
        if (ints[j] == target - ints[i])
          return new int[]{i, j};
      }
    }

    throw  new IllegalArgumentException("no twoSum solution");
  }

  public static int[] twoSumHashMap(int[] ints, int target) {

    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < ints.length; i++) {
      int complement = target - ints[i];
      if (numMap.containsKey(complement)) {
        return new int[] {i, numMap.get(complement)};
      }
      numMap.put(ints[i],i);
    }

    throw  new IllegalArgumentException("no twoSum solution");
  }
}
