package ch.alika.leetcode.easy;

import org.junit.jupiter.api.Test;

import static ch.alika.leetcode.easy.Helper.intArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * see: https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSum1DArrayTests {

  private int[] runningSum(int[] ints) {
    return RunningSum1DArray.runningSum(ints);
  }

  @Test
  void where_running_sum_of_array_computed() {
    assertThat(runningSum(intArray()), equalTo(intArray()));
    assertThat(runningSum(intArray(1)), equalTo(intArray(1)));
    assertThat(runningSum(intArray(1, 2)), equalTo(intArray(1, 3)));

    // LeetCode test example
    assertThat(runningSum(intArray(3,1,2,10,1)), equalTo(intArray(3,4,6,16,17)));
  }

}
