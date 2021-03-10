package ch.alika.leetcode.easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * see: https://www.geeksforgeeks.org/two-pointers-technique/
 */
public class RemoveDuplicatesFromSortedArray {
  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;

    int leftIndex = 0;
    for (int rightIndex = 1; rightIndex < nums.length; rightIndex++) {
      if (nums[leftIndex] != nums[rightIndex]) {
        nums[++leftIndex] = nums[rightIndex];
      }
    }

    return leftIndex + 1;
  }
}
