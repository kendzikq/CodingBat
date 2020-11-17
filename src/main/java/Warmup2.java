import java.util.StringJoiner;

public class Warmup2 {

    // Given a string and a non-negative int n, return a larger string that is n copies of the
    // original string.
    public String stringTimes(String str, int n) {

        StringJoiner joiner = new StringJoiner("");
        for (int i = 0; i < n; i++)
            joiner.add(str);
        return joiner.toString();
    }

    // Given a string and a non-negative int n, we'll say that the front of the string is the first 3
    // chars, or whatever is there if the string is less than length 3. Return n copies of the front;
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

    // Count the number of "xx" in the given string. We'll say that overlapping is allowed, so
    // "xxx" contains 2 "xx".
    public int countXX(String str) {
        int counter = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ("xx".equals(str.substring(i, i + 2))) {
                counter++;
            }
        }
        return counter;
    }

    // Given a string, return true if the first instance of "x" in the string is immediately followed
    // by another "x".
    boolean doubleX(String str) {
        int firstX = str.indexOf('x');
        if ((firstX + 1) != str.length() && firstX >= 0 && (str.charAt(firstX + 1) == 'x'))
            return true;
        return false;
    }

    // Given a string, return a new string made of every other char starting with the first, so
    // "Hello" yields "Hlo".
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
}