import java.util.StringJoiner;

public class Warmup1 {

    // The parameter weekday is true if it is a weekday, and the parameter vacation is true if we
    // are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we
    // sleep in.
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation)
            return true;
        return false;
    }

    // We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
    // We are in trouble if they are both smiling or if neither of them is smiling.
    // Return true if we are in trouble
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile ^ bSmile)
            return false;
        return true;
    }

    // Given two int values, return their sum. Unless the two values are the same, then return
    // double their sum.
    public int sumDouble(int a, int b) {
        int sum = a + b;
        if (a == b) {
            return 2 * sum;
        }
        return sum;
    }

    // Given an int n, return the absolute difference between n and 21, except return double the
    // absolute difference if n is over 21.
    public int diff21(int n) {
        if (n <= 21)
            return 21 - n;
        return (n - 21) * 2;
    }

    // We have a loud talking parrot. The "hour" parameter is the current hour time in the range
    // 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20.
    // Return true if we are in trouble.
    public boolean parrotTrouble(boolean talking, int hour) {
        return (talking && (hour < 7 || hour > 20));
    }

    // Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a + b == 10;
    }

    // Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes
    // the absolute value of a number.
    public boolean nearHundred(int n) {
        return (Math.abs(100 - n) <= 10 || (Math.abs(200 - n) <= 10));
    }

    // Given 2 int values, return true if one is negative and one is positive.
    // Except if the parameter "negative" is true, then return true only if both are negative.
    public boolean posNeg(int a, int b, boolean negative) {
        return negative ? a < 0 && b < 0 : (a > 0 && b < 0) || (a < 0 && b > 0);
    }

    // Given a string, return a new string where "not " has been added to the front.
    // However, if the string already begins with "not", return the string unchanged.
    // Note: use .equals() to compare 2 strings.
    public String notString(String str) {
        if (str.length() >= 3 && "not".equals(str.substring(0, 3))) {
            return str;
        }
        return "not " + str;
    }

    // Given a non-empty string and an int n, return a new string where the char at index n has
    // been removed. The value of n will be a valid index of a char in the original string (i.e. n will
    // be in the range 0..str.length()-1 inclusive).
    public String missingChar(String str, int n) {
        StringJoiner joiner = new StringJoiner("");
        return joiner.add(str.substring(0, n)).add(str.substring(n + 1, str.length())).toString();
    }

    // Given a string, return a new string where the first and last chars have been exchanged.
    public String frontBack(String str) {
        if (str.length() < 2)
            return str;
        return str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
    }

    // Given a string, we'll say that the front is the first 3 chars of the string. If the string length
    // is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.
    public String front3(String str) {
        String front = str.length() > 3 ? str.substring(0, 3) : str;
        return front + front + front;
    }

    // Given a string, take the last char and return a new string with the last char added at the
    // front and back, so "cat" yields "tcatt". The original string will be length 1 or more.
    public String backAround(String str) {
        StringJoiner joiner = new StringJoiner("");
        return joiner.add(str.substring(str.length() - 1)).add(str).add(str.substring(str.length() - 1)).toString();
    }

    // Return true if the given non-negative number is a multiple of 3 or a multiple of 5. Use the
    // % "mod" operator -- see Introduction to Mod
    public boolean or35(int n) {
        return n % 3 == 0 || n % 5 == 0;
    }

    // Given a string, take the first 2 chars and return the string with the 2 chars added at both
    // the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use
    // whatever chars are there.
    public String front22(String str) {
        String sub = str.length() < 2 ? str : str.substring(0, 2);
        return sub + str + sub;
    }

    // Given a string, return true if the string starts with "hi" and false otherwise.
    public boolean startHi(String str) {
        StringJoiner joiner = new StringJoiner("");
        if (str.length() < 2)
            return false;
        return "hi".equals(joiner.add(str.substring(0, 2)).toString()) ? true : false;
    }

    // Given two temperatures, return true if one is less than 0 and the other is greater than 100.
    public boolean icyHot(int temp1, int temp2) {
        return (temp1 < 0 && temp2 > 100) || (temp2 < 0 && temp1 > 100);
    }

    // Given 2 int values, return true if either of them is in the range 10..20 inclusive.
    public boolean in1020(int a, int b) {
        return (a >= 10 && a <= 20)
                || (b >= 10 && b <= 20);
    }

    // We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 3 int values,
    // return true if 1 or more of them are teen.
    //
    // hasTeen(13, 20, 10) → true
    // hasTeen(20, 19, 10) → true
    // hasTeen(20, 10, 13) → true
    public boolean hasTeen(int a, int b, int c) {
        return (a >= 13 && a <= 19) ||
                (b >= 13 && b <= 19) ||
                (c >= 13 && c <= 19);
    }

    // We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 2 int values,
    // return true if one or the other is teen, but not both.
    //
    // loneTeen(13, 99) → true
    // loneTeen(21, 19) → true
    // loneTeen(13, 13) → false
    public boolean loneTeen(int a, int b) {
        boolean st1 = a >= 13 && a <= 19;
        boolean st2 = b >= 13 && b <= 19;
        return st1 ^ st2;
    }

    // Given a string, if the string "del" appears starting at index 1, return a string where that
    // "del" has been deleted. Otherwise, return the string unchanged.
    //
    // delDel("adelbc") → "abc"
    // delDel("adelHello") → "aHello"
    // delDel("adedbc") → "adedbc"
    public String delDel(String str) {
        final String del = "del";
        if (str.length() >= 4 && str.substring(1, 4).contains(del)) {
            return str.substring(0, 1) + str.substring(4);
        }
        return str;
    }
}
