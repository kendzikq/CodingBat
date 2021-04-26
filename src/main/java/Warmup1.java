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

    /*
    Return true if the given string begins with "mix", except the 'm' can be anything, so "pix",
    "9ix" .. all count.

    mixStart("mix snacks") → true
    mixStart("pix snacks") → true
    mixStart("piz snacks") → false
     */
    public boolean mixStart(String str) {
        final String regex = "^.ix.*";
        return str.matches(regex);
    }

    /*
    Given a string, return a string made of the first 2 chars (if present), however include first
    char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".

    startOz("ozymandias") → "oz"
    startOz("bzoo") → "z"
    startOz("oxx") → "o"

     */
    public String startOz(String str) {
        String s1 = "";
        String s2 = "";
        if (str.length() >= 1 && str.charAt(0) == 'o')
            s1 = str.substring(0, 1);
        if (str.length() >= 2 && str.charAt(1) == 'z')
            s2 = str.substring(1, 2);
        return s1 + s2;
    }

    /*
    Given three int values, a b c, return the largest.

    intMax(1, 2, 3) → 3
    intMax(1, 3, 2) → 3
    intMax(3, 2, 1) → 3
     */
    public int intMax(int a, int b, int c) {

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    /*
    Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the
    event of a tie. Note that Math.abs(n) returns the absolute value of a number.

    close10(8, 13) → 8
    close10(13, 8) → 8
    close10(13, 7) → 0
     */
    public int close10(int a, int b) {
        int aAbs = Math.abs(a - 10);
        int bAbs = Math.abs(b - 10);

        return aAbs == bAbs ? 0 : aAbs < bAbs ? a : b;
    }

    /*
    Given 2 int values, return true if they are both in the range 30..40 inclusive, or they are
    both in the range 40..50 inclusive.

    in3050(30, 31) → true
    in3050(30, 41) → false
    in3050(40, 50) → true
     */
    public boolean in3050(int a, int b) {
        boolean condition1 = (a >= 30 && a <= 40) && (b >= 30 && b <= 40);
        boolean condition2 = (a >= 40 && a <= 50) && (b >= 40 && b <= 50);
        return condition1 || condition2;
    }

    /*
    Given 2 positive int values, return the larger value that is in the range 10..20 inclusive, or
    return 0 if neither is in that range.

    max1020(11, 19) → 19
    max1020(19, 11) → 19
    max1020(11, 9) → 11
     */
    public int max1020(int a, int b) {

        boolean isAInRange = a >= 10 && a <= 20;
        boolean isBInRange = b >= 10 && b <= 20;

        if (isAInRange && isBInRange) {
            return Math.max(a, b);
        }

        return isAInRange ? a : isBInRange ? b : 0;
    }

    /*
    Return true if the given string contains between 1 and 3 'e' chars.

    stringE("Hello") → true
    stringE("Heelle") → true
    stringE("Heelele") → false
     */
    public boolean stringE(String str) {
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                counter++;
            }
        }

        return counter >= 1 && counter <= 3;
    }

    /*
    Given two non-negative int values, return true if they have the same last digit, such as
    with 27 and 57. Note that the % "mod" operator computes remainders, so 17 % 10 is 7.

    lastDigit(7, 17) → true
    lastDigit(6, 17) → false
    lastDigit(3, 113) → true
     */
    public boolean lastDigit(int a, int b) {
        return a % 10 == b % 10;
    }

    /*
    Given a string, return a new string where the last 3 chars are now in upper case.
    If the string has less than 3 chars, uppercase whatever is there. Note that str.toUpperCase()
    returns the uppercase version of a string.

    endUp("Hello") → "HeLLO"
    endUp("hi there") → "hi thERE"
    endUp("hi") → "HI"
     */
    public String endUp(String str) {

        if (str.length() < 3) {
            return str.toUpperCase();
        }

        return str.substring(0, str.length() - 3) + str.substring(str.length() - 3).toUpperCase();
    }

    /*
    Given a non-empty string and an int N, return the string made starting with char 0, and
    then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or
    more.

    everyNth("Miracle", 2) → "Mrce"
    everyNth("abcdefg", 2) → "aceg"
    everyNth("abcdefg", 3) → "adg"
     */
    public String everyNth(String str, int n) {
        String result = "";

        for (int i = 0; i < str.length(); i += n) {
            result += str.charAt(i);
        }

        return result;
    }
}
