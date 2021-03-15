package ch.alika.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ch.alika.leetcode.helper.IntHelpers.intArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayIITests {

  private int[] removeDuplicates(int[] nums) {
    int len = RemoveDuplicatesFromSortedArrayII.removeDuplicates(nums);
    return Arrays.copyOf(nums,len);
  }

  @Test
  void where_no_duplicates() {
    assertThat(removeDuplicates(intArray()), equalTo(intArray()));
    assertThat(removeDuplicates(intArray(0)), equalTo(intArray(0)));
    assertThat(removeDuplicates(intArray(1, 2, 3)), equalTo(intArray(1, 2, 3)));
  }

  @Test
  void where_duplicates_exist() {
    assertThat(removeDuplicates(intArray(1, 1, 1)), equalTo(intArray(1, 1)));
    assertThat(removeDuplicates(intArray(0, 1, 1, 1)), equalTo(intArray(0, 1, 1)));
    assertThat(removeDuplicates(intArray(0, 1, 1, 1, 2)), equalTo(intArray(0, 1, 1, 2)));
  }

  @Test
  void where_leetcode_testcase() {
    assertThat(removeDuplicates(intArray(1, 1, 1, 2, 2, 3)), equalTo(intArray(1, 1, 2, 2, 3)));
    assertThat(removeDuplicates(intArray(0, 0, 1, 1, 1, 1, 2, 3, 3)), equalTo(intArray(0, 0, 1, 1, 2, 3, 3)));
  }

}
