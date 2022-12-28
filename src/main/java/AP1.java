import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AP1 {

    // Given an array of scores, return true if each score is equal or greater than the one before.
    // The array will be length 2 or more.
    public boolean scoresIncreasing(int[] scores) {
        int previous = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < previous)
                return false;
            previous = scores[i];
        }
        return true;
    }

    // Given an array of scores, return true if there are scores of 100 next to each other in the
    // array. The array length will be at least 2.
    public boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100 && scores[i + 1] == 100) {
                return true;
            }
        }
        return false;
    }

    // Given an array of scores sorted in increasing order, return true if the array contains 3
    // adjacent scores that differ from each other by at most 2, such as with {3, 4, 5} or {3, 5, 5}
    public boolean scoresClump(int[] scores) {
        for (int i = 0; i < scores.length - 2; i++) {
            if (scores[i + 2] - scores[i] <= 2) { //scores are sorted in increasing order
                return true;
            }
        }
        return false;
    }

    // Given an array of scores, compute the int average of the first half and the second half, and
    // return whichever is larger. We'll say that the second half begins at index length/2. The
    // array length will be at least 2. To practice decomposition, write a separate helper method
    // int average(int[] scores, int start, int end) { which computes the average of the
    // elements between indexes start..end. Call your helper method twice to implement
    // scoresAverage(). Write your helper method after your scoresAverage() method in the
    // JavaBat text area. Normally you would compute averages with doubles, but here we use ints
    // so the expected results are exact.
    public int scoresAverage(int[] scores) {
        int half1 = average(scores, 0, scores.length / 2);
        int half2 = average(scores, scores.length / 2, scores.length);
        return Math.max(half1, half2);
    }

    private int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum + scores[i];
        }
        return sum > 0 ? sum / (end - start) : 0;
    }

    // Given an array of strings, return the count of the number of strings with the given length.
    public int wordsCount(String[] words, int len) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == len) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Given an array of strings, return a new array containing the first N strings. N will be in the
     * range 1..length.
     */
    public String[] wordsFront(String[] words, int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = words[i];
        }
        return result;
    }

    /**
     * Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the
     * given length are omitted. See wordsWithout() below which is more difficult because it uses arrays.
     */
    public List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<>();
        list = Arrays.stream(words).filter(x -> x.length() != len).collect(Collectors.toList());
        return list;
    }

    /**
     * Given a positive int n, return true if it contains a 1 digit. Note: use % to get the rightmost
     * digit, and / to discard the rightmost digit.
     */
    public boolean hasOne(int n) {
        while (n > 0) {
            if (n % 10 == 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    /**
     * We'll say that a positive int divides itself if every digit in the number divides into the
     * number evenly. So for example 128 divides itself since 1, 2, and 8 all divide into 128
     * evenly. We'll say that 0 does not divide into anything evenly, so no number with a 0 digit
     * divides itself. Note: use % to get the rightmost digit, and / to discard the rightmost digit.
     */
    public boolean dividesSelf(int n) {
        int tmp = n;
        while (tmp > 0) {
            int digit = tmp % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }

    /**
     * Given an array of positive ints, return a new array of length "count" containing the first
     * even numbers from the original array. The original array will contain at least "count" even numbers.
     */
    public int[] copyEvens(int[] nums, int count) {
        int[] array = new int[count];
        int j = 0;
        for (int i = 0; i < nums.length && count > 0; i++) {
            if (nums[i] % 2 == 0) {
                array[j++] = nums[i];
                count--;
            }
        }
        return array;
    }

    /**
     * We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive).
     * Given an array of positive ints, return a new array of length "count" containing the first
     * endy numbers from the original array. Decompose out a separate isEndy(int n) method to
     * test if a number is endy. The original array will contain at least "count" endy numbers.
     */
    public int[] copyEndy(int[] nums, int count) {
        int[] result = new int[count];
        for (int numsIdx = 0, endyIdx = 0;
             numsIdx < nums.length && endyIdx < count;
             numsIdx++) {
            if (isEndy(nums[numsIdx])) {
                result[endyIdx] = nums[numsIdx];
                endyIdx++;
            }
        }
        return result;
    }

    private boolean isEndy(int n) {
        return (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
    }

    /**
     * Given 2 arrays that are the same length containing strings, compare the 1st string in one
     * array to the 1st string in the other array, the 2nd to the 2nd and so on. Count the number
     * of times that the 2 strings are non-empty and start with the same char. The strings may be
     * any length, including 0.
     */
    public int matchUp(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) { // a.length == b.length
            String strA = a[i];
            String strB = b[i];
            if (strA.length() > 0
                && strB.length() > 0
                && strA.charAt(0) == strB.charAt(0)) {
                count++;
            }
        }
        return count;
    }

    /**
     * The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b", "b"}.
     * the "answers" array contains a student's answers, with "?" representing a question left blank.
     * The two arrays are not empty and are the same length. Return the score for this array of answers,
     * giving +4 for each correct answer, -1 for each incorrect answer, and +0 for each blank answer.
     * scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
     */
    public int scoreUp(String[] key, String[] answers) {
        int result = 0;
        for (int i = 0; i < key.length; i++) {
            if (answers[i].equals(key[i])) {
                result += 4;
            } else if (!"?".equals(answers[i])) {
                result -= 1;
            }
        }
        return result;
    }

    /**
     * Given an array of strings, return a new array without the strings that are equal to the target string.
     * One approach is to count the occurrences of the target string, make a new array of the correct length,
     * and then copy over the correct strings.
     * wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
     * wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
     * wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
     */
    public String[] wordsWithout(String[] words, String target) {
        return Arrays.stream(words)
            .filter(w -> !target.equals(w))
            .toArray(String[]::new);
    }

    /**
     * Given two arrays, A and B, of non-negative int scores. A "special" score is one which is a multiple of 10,
     * such as 40 or 90. Return the sum of largest special score in A and the largest special score in B.
     * To practice decomposition, write a separate helper method which finds the largest special score in an array.
     * Write your helper method after your scoresSpecial() method in the JavaBat text area.
     * scoresSpecial([12, 10, 4], [2, 20, 30]) → 40
     * scoresSpecial([20, 10, 4], [2, 20, 10]) → 40
     * scoresSpecial([12, 11, 4], [2, 20, 31]) → 20
     */
    public int scoresSpecial(int[] a, int[] b) {
        int highestSpecialScoreA = takeHighestSpecialScoreStreamVariant(a);
        int highestSpecialScoreB = takeHighestSpecialScoreStreamVariant(b);

        return highestSpecialScoreA + highestSpecialScoreB;
    }

    /**
     * traditional approach
     */
    private int takeHighestSpecialScore(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 10 == 0 && result < array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    /**
     * java streams modern approach
     */
    private int takeHighestSpecialScoreStreamVariant(int[] array) {
        return Arrays.stream(array)
            .filter(n -> n % 10 == 0)
            .max()
            .orElse(0);
    }

    /**
     * We have an array of heights, representing the altitude along a walking trail.
     * Given start/end indexes into the array, return the sum of the changes for a
     * walk beginning at the start index and ending at the end index. For example,
     * with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6.
     * The start end end index will both be valid indexes into the array with start <= end.
     * sumHeights([5, 3, 6, 7, 2], 2, 4) → 6
     * sumHeights([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights([5, 3, 6, 7, 2], 0, 4) → 11
     */
    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum + Math.abs(heights[i + 1] - heights[i]);
        }
        return sum;
    }

    /**
     * (A variation on the sumHeights problem.)
     * We have an array of heights, representing the altitude along a walking trail.
     * Given start/end indexes into the array, return the sum of the changes for a
     * walk beginning at the start index and ending at the end index,
     * however increases in height count double. For example,
     * with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1*2 + 5 = 7.
     * The start end end index will both be valid indexes into the array with start <= end.
     * sumHeights2([5, 3, 6, 7, 2], 2, 4) → 7
     * sumHeights2([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights2([5, 3, 6, 7, 2], 0, 4) → 15
     */
    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                sum += 2 * diff;
            } else {
                sum += Math.abs(diff);
            }
        }
        return sum;
    }

    /**
     * (A variation on the sumHeights problem.)
     * We have an array of heights, representing the altitude along a walking trail.
     * Given start/end indexes into the array, return the number of "big" steps
     * for a walk starting at the start index and ending at the end index.
     * We'll say that step is big if it is 5 or more up or down.
     * The start end end index will both be valid indexes into the array with start <= end.
     * bigHeights([5, 3, 6, 7, 2], 2, 4) → 1
     * bigHeights([5, 3, 6, 7, 2], 0, 1) → 0
     * bigHeights([5, 3, 6, 7, 2], 0, 4) → 1
     */
    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            int abs = Math.abs(heights[i + 1] - heights[i]);
            if (abs >= 5) {
                count++;
            }
        }
        return count;
    }
}
