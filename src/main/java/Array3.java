public class Array3 {

    // Consider the leftmost and righmost appearances of some value in an array. We'll say that
    // the "span" is the number of elements between the two inclusive. A single value has a
    // span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
    public int maxSpan(int[] nums) {
        int span = 0;
        int diffL = 0;
        int diffP = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[0] == nums[i])
                diffL = i + 1;
            if (nums[nums.length - 1] == nums[j])
                diffP = i + 1;
            if (i == nums.length - 1)
                span = Math.max(diffP, diffL);
        }
        return span;
    }

    // Return an array that contains exactly the same numbers as the given array, but rearranged
    // so that every 3 is immediately followed by a 4. Do not move the 3's, but every other
    // number may move. The array contains the same number of 3's and 4's, every 3 has a
    // number after it that is not a 3, and a 3 appears in the array before any 4.
    public int[] fix34(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] == 3 && nums[j + 1] != 4) {
                        int swap = nums[j + 1];
                        nums[j + 1] = 4;
                        nums[i] = swap;
                        break;
                    }
                }
            }
        }
        return nums;
    }
}
