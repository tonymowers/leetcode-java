package ch.alika.leetcode;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *
 * see: https://leetcode.com/problems/two-sum/
 */
public class SolutionTwoSumTests {

  private TwoSumImplementation twoSumFunction;

  private int[] twoSum(int[] ints, int target) {
    return twoSumFunction.invoke(ints,target);
  }

  @ParameterizedTest
  @EnumSource(TwoSumImplementation.class)
  void where_no_two_sum_solution_found(TwoSumImplementation twoSumFunction) {
    this.twoSumFunction = twoSumFunction;
    assertThrows(IllegalArgumentException.class, () -> twoSum(intArray(0), 0));
    assertThrows(IllegalArgumentException.class, () -> twoSum(intArray(0,0), 1));
  }

  @ParameterizedTest
  @EnumSource(TwoSumImplementation.class)
  void where_two_sum_solution_found(TwoSumImplementation twoSumFunction) {
    this.twoSumFunction = twoSumFunction;
    assertThat(twoSum(intArray(1, 2), 3), equalAnyOrder(intArray(0, 1)));
    assertThat(twoSum(intArray(1, 0, 2), 3), equalAnyOrder(intArray(0, 2)));
    assertThat(twoSum(intArray(0, 1, 2), 3), equalAnyOrder(intArray(1, 2)));
  }

  private enum TwoSumImplementation {
    BRUTE_FORCE(SolutionTwoSum::twoSumBruteForce),
    HASH_MAP(SolutionTwoSum::twoSumHashMap);

    private interface TwoSumFunction {
      int[] invoke(int[] ints, int target);
    }

    private final TwoSumFunction twoSumFunction;

    TwoSumImplementation(TwoSumFunction fn) {
      this.twoSumFunction = fn;
    }

    public int[] invoke(int[] ints, int target) {
      return twoSumFunction.invoke(ints, target);
    }
  }

  private static int[] intArray(int ...a) {
    return a;
  }

  private IsEqualAnyOrder equalAnyOrder(int[] numbs) {
    return new IsEqualAnyOrder(numbs);
  }

  private static class IsEqualAnyOrder extends TypeSafeMatcher<int[]> {

    private final int[] ints;

    private IsEqualAnyOrder(int[] ints) {
      this.ints = ints;
    }

    @Override
    protected boolean matchesSafely(int[] otherInts) {
      final int a0 = otherInts[0];
      final int a1 = otherInts[1];
      return isEqualTo(a0, a1) || isEqualTo(a1, a0);
    }

    private boolean isEqualTo(int a0, int a1) {
      return ints[0] == a0 && ints[1] == a1;
    }

    @Override
    public void describeTo(Description description) {
      equalTo(ints).describeTo(description);
    }
  }
}
