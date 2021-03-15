package ch.alika.leetcode.medium;

/**
 * see: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * see: https://www.geeksforgeeks.org/two-pointers-technique/
 */
public class RemoveDuplicatesFromSortedArrayII {
  static public int removeDuplicates(int[] nums) {
    int len = 0;
    for (int number : nums) {
      if (numberShouldBeAppendedToResult(nums,len,number)) {
        nums[len++] = number;
      }
    }
    return len;
  }

  static private boolean numberShouldBeAppendedToResult(int[] nums, int len, int number) {
    return len < 2 || nums[len - 2] != number;
  }
}
