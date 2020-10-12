public class Array2 {

    // Return the number of even ints in the given array. Note: the % "mod" operator computes
    // the remainder, e.g. 5 % 2 is 1.
    public int countEvens(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i % 2 == 0)
                count++;
        }
        return count;
    }

    // Given an array length 1 or more of ints, return the difference between the largest and
    // smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2)
    // methods return the smaller or larger of two values.
    public int bigDiff(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        return max - min;
    }

    // Return the "centered" average of an array of ints, which we'll say is the mean average of
    // the values, except ignoring the largest and smallest values in the array. If there are
    // multiple copies of the smallest value, ignore just one copy, and likewise for the largest
    // value. Use int division to produce the final average. You may assume that the array is
    // length 3 or more.
    public int centeredAverage(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return (sum - max - min) / (nums.length - 2);
    }

    // Return the sum of the numbers in the array, returning 0 for an empty array. Except the
    // number 13 is very unlucky, so it does not count and numbers that come immediately after
    // a 13 also do not count.
    public int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
                continue;
            }
            sum = sum + nums[i];
        }
        return sum;
    }

    // Return the sum of the numbers in the array, except ignore sections of numbers starting
    // with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0
    // for no numbers.
    public int sum67(int[] nums) {
        int sum = 0;
        boolean is6flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) {
                is6flag = true;
            }

            if (!is6flag) {
                sum += nums[i];
            }

            if (is6flag && nums[i] == 7) {
                is6flag = false;
            }
        }
        return sum;
    }

    // Given an array of ints, return true if the array contains a 2 next to a 2 somewhere
    public boolean has22(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 2 && nums[i] == 2) {
                return true;
            }
        }
        return false;
    }
}
