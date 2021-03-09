package ch.alika.leetcode.easy;

/**
 * see: https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSum1DArray {
  public static int[] runningSum(int[] ints) {
    int[] result = new int[ints.length];
    int runningSum = 0;

    for (int i = 0; i < ints.length; i++) {
      runningSum += ints[i];
      result[i] = runningSum;
    }
    return result;
  }
}
