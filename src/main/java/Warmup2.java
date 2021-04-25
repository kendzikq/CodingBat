import java.util.Arrays;
import java.util.StringJoiner;

public class Warmup2 {

    /*
    Given a string and a non-negative int n, return a larger string that is n copies of the
    original string.
     */
    public String stringTimes(String str, int n) {

        StringJoiner joiner = new StringJoiner("");
        for (int i = 0; i < n; i++)
            joiner.add(str);
        return joiner.toString();
    }

    /*
    Given a string and a non-negative int n, we'll say that the front of the string is the first 3
    chars, or whatever is there if the string is less than length 3. Return n copies of the front;
    */
    public String frontTimes(String str, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String front;
        if (str.length() > 3)
            front = str.substring(0, 3);
        else
            front = str;
        for (int i = 0; i < n; i++)
            stringBuilder.append(front);
        return stringBuilder.toString();
    }

    /*
    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so
    "xxx" contains 2 "xx".
     */
    public int countXX(String str) {
        int counter = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ("xx".equals(str.substring(i, i + 2))) {
                counter++;
            }
        }
        return counter;
    }

    /*
    Given a string, return true if the first instance of "x" in the string is immediately followed
    by another "x".
     */
    boolean doubleX(String str) {
        int firstX = str.indexOf('x');
        if ((firstX + 1) != str.length() && firstX >= 0 && (str.charAt(firstX + 1) == 'x'))
            return true;
        return false;
    }

    /*
    Given a string, return a new string made of every other char starting with the first, so
    "Hello" yields "Hlo".
     */
    public String stringBits(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 2) {
            result = result + str.charAt(i);
        }
        return result;
    }

    // Given a non-empty string like "Code" return a string like "CCoCodCode".
    public String stringSplosion(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.substring(0, i + 1);
        }
        return result;
    }

    /*
    Given a string, return the count of the number of times that a substring length 2 appears
    in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count
    the end substring).

    last2("hixxhi") → 1
    last2("xaxxaxaxx") → 1
    last2("axxxaaxx") → 2
     */
    public int last2(String str) {
        if (str.length() <= 2) {
            return 0;
        }

        String sub = str.substring(str.length() - 2, str.length());
        int count = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals(sub)) {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array of ints, return the number of 9's in the array.

    arrayCount9([1, 2, 9]) → 1
    arrayCount9([1, 9, 9]) → 2
    arrayCount9([1, 9, 9, 3, 9]) → 3
     */
    public int arrayCount9(int[] nums) {
        return (int) Arrays.stream(nums).filter(x -> x == 9).count();
    }

    /*
    Given an array of ints, return true if one of the first 4 elements in the array is a 9.
    The array length may be less than 4.

    arrayFront9([1, 2, 9, 3, 4]) → true
    arrayFront9([1, 2, 3, 4, 9]) → false
    arrayFront9([1, 2, 3, 4, 5]) → false
     */
    public boolean arrayFront9(int[] nums) {
        return Arrays.stream(nums).limit(4).anyMatch(n -> n == 9);
    }

    /*
    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array
    somewhere.

    array123([1, 1, 2, 3, 1]) → true
    array123([1, 1, 2, 4, 1]) → false
    array123([1, 1, 2, 1, 2, 3]) → true
     */
    public boolean array123(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }

    /*
    Given 2 strings, a and b, return the number of the positions where they contain the same
    length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az"
    substrings appear in the same place in both strings.

    stringMatch("xxcaazz", "xxbaaz") → 3
    stringMatch("abc", "abc") → 2
    stringMatch("abc", "axc") → 0
     */
    public int stringMatch(String a, String b) {
        int minLen = Math.min(a.length(), b.length());
        int counter = 0;
        for (int i = 0; i < minLen - 1; i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                counter++;
            }
        }
        return counter;
    }

    /*
    Given a string, return a version where all the "x" have been removed. Except an "x" at the
    very start or end should not be removed.

    stringX("xxHxix") → "xHix"
    stringX("abxxxcd") → "abcd"
    stringX("xabxxxcdx") → "xabcdx"
     */
    public String stringX(String str) {

        if (str.length() <= 2) {
            return str;
        }

        String beginning = str.substring(0, 1);
        String middle = str.substring(1, str.length() - 1).replaceAll("x", "");
        String end = str.substring(str.length() - 1);

        return beginning + middle + end;
    }
}