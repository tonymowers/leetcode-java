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

  @ParameterizedTest
  @EnumSource(TwoSumImplementation.class)
  void where_not_enough_input_numbers(TwoSumImplementation twoSumFunction) {
    assertThrows(IllegalArgumentException.class, () -> twoSumFunction.invoke(arrayOfInts(0), 0));
  }

  @ParameterizedTest
  @EnumSource(TwoSumImplementation.class)
  void where_target_sum_not_found(TwoSumImplementation twoSumFunction) {
    assertThrows(IllegalArgumentException.class, () -> twoSumFunction.invoke(arrayOfInts(0,0), 1));
  }

  @ParameterizedTest
  @EnumSource(TwoSumImplementation.class)
  void where_target_sum_found(TwoSumImplementation twoSumFunction) {
    assertThat(twoSumFunction.invoke(arrayOfInts(0,0),0),equalAnyOrder(arrayOfInts(0, 1)));
    assertThat(twoSumFunction.invoke(arrayOfInts(1,2,0),1),equalAnyOrder(arrayOfInts(0,2)));
    assertThat(twoSumFunction.invoke(arrayOfInts(0,1,1),2),equalAnyOrder(arrayOfInts(1,2)));
    assertThat(twoSumFunction.invoke(arrayOfInts(0,0,1,1),2),equalAnyOrder(arrayOfInts(3,2)));
    assertThat(twoSumFunction.invoke(arrayOfInts(1,0,0,1),2),equalAnyOrder(arrayOfInts(0,3)));
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

  private static int[] arrayOfInts(int ...a) {
    return a;
  }

  private IsEqualAnyOrder equalAnyOrder(int[] numbs) {
    return new IsEqualAnyOrder(numbs);
  }

  public static class IsEqualAnyOrder extends TypeSafeMatcher<int[]> {

    private final int[] numbs;

    public IsEqualAnyOrder(int[] numbs) {
      this.numbs = numbs;
    }

    @Override
    protected boolean matchesSafely(int[] ints) {
      return isEqualToNumbsPair(ints[0],ints[1]) || isEqualToNumbsPair(ints[1],ints[0]);
    }

    @Override
    public void describeTo(Description description) {
        equalTo(numbs).describeTo(description);
    }

    private boolean isEqualToNumbsPair(int a, int b) {
      return  (a == numbs[0] && b == numbs[1]);
    }
  }
}
