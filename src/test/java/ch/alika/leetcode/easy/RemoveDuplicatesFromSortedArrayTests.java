package ch.alika.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ch.alika.leetcode.easy.Helper.intArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArrayTests {

  @Test
  void where_no_duplicates() {
    assertThat(rmDuplicates(intArray()), equalTo(result(0, intArray())));
    assertThat(rmDuplicates(intArray(1)), equalTo(result(1, intArray(1))));
  }

  @Test
  void where_duplicates_exist() {
    assertThat(rmDuplicates(intArray(1, 1)), equalTo(result(1, intArray(1))));
    assertThat(rmDuplicates(intArray(1, 1, 1)), equalTo(result(1, intArray(1))));
    assertThat(rmDuplicates(intArray(1, 1, 2)), equalTo(result(2, intArray(1, 2))));
  }

  private Result result(int len, int[] numbs) {
    return new Result(len, numbs);
  }

  private Result rmDuplicates(int[] numbs) {
    return result(RemoveDuplicatesFromSortedArray.removeDuplicates(numbs), numbs);
  }

  private static class Result {
    private final int len;
    private final int[] nums;

    public Result(int len, int[] nums) {
      this.len = len;
      this.nums = nums;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Result))
        return false;

      Result other = (Result) obj;
      return this.len == other.len && hasEqualivalentIntArray(other);
    }

    private boolean hasEqualivalentIntArray(Result other) {
      boolean result = true;
      for (int i = 0; i < other.len && result; i++) {
        result = (other.nums[i] == (this.nums[i]));
      }
      return result;
    }

    @Override
    public String toString() {
      return "result[len =" + len + ", numbs =" + numsToString() + "]";
    }

    private String numsToString() {
      return Arrays.toString(Arrays.copyOfRange(nums, 0, len));
    }
  }
}
