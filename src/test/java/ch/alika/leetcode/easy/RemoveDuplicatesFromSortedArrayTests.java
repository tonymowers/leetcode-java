package ch.alika.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ch.alika.leetcode.helper.IntHelpers.intArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArrayTests {

  private int[] removeDuplicates(int[] numbs) {
    final int len = RemoveDuplicatesFromSortedArray.removeDuplicates(numbs);
    return Arrays.copyOf(numbs, len);
  }

  @Test
  void where_no_duplicates() {
    assertThat(removeDuplicates(intArray()), equalTo(intArray()));
    assertThat(removeDuplicates(intArray(1)), equalTo(intArray(1)));
  }

  @Test
  void where_duplicates_exist() {
    assertThat(removeDuplicates(intArray(1, 1)), equalTo(intArray(1)));
    assertThat(removeDuplicates(intArray(1, 1, 1)), equalTo(intArray(1)));
    assertThat(removeDuplicates(intArray(1, 1, 2)), equalTo(intArray(1, 2)));
  }

}
