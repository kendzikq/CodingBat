public class Array1 {

    public boolean firstLast6(int[] nums) {
        return (nums[0] == 6 || nums[nums.length - 1] == 6);
    }

    public boolean sameFirstLast(int[] nums) {
        if (nums.length >= 1 && nums[0] == nums[nums.length - 1])
            return true;
        return false;
    }

    public int[] makePi() {
        return new int[]{3, 1, 4};
    }

}
