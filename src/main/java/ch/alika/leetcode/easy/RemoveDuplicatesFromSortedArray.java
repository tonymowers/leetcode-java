package ch.alika.leetcode.easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * see: https://www.geeksforgeeks.org/two-pointers-technique/
 */
public class RemoveDuplicatesFromSortedArray {
  public static int removeDuplicates(int[] nums) {
    int len = 0;
    for (int number : nums) {
      if (len < 1 || nums[len - 1] != number) {
        nums[len++] = number;
      }
    }

    return len;
  }
}
