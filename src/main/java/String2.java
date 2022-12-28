import java.util.StringJoiner;

public class String2 {

    /**
     * Given a string, return a string where for every char in the original, there are two chars.
     */
    public String doubleChar(String str) {
        StringJoiner joiner = new StringJoiner("");
        for (int i = 0; i < str.length(); i++) {
            joiner.add(str.substring(i, i + 1)).add(str.substring(i, i + 1));
        }
        return joiner.toString();
    }

    /**
     * Return the number of times that the string "hi" appears anywhere in the given string.
     */
    public int countHi(String str) {
        int result = 0;
        String pattern = "hi";
        for (int i = 0; i < str.length() - 1; i++) {
            if (pattern.equals(str.substring(i, i + 2)))
                result++;
        }
        return result;
    }

    /**
     * Return true if the string "cat" and "dog" appear the same number of times in the given string.
     */
    public boolean catDog(String str) {
        int catN = 0;
        int dogN = 0;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'a' && str.charAt(i - 1) == 'c' && str.charAt(i + 1) == 't') {
                catN++;
            } else if (str.charAt(i) == 'o' && str.charAt(i - 1) == 'd' && str.charAt(i + 1) == 'g') {
                dogN++;
            }
        }
        return catN == dogN;
    }

    /**
     * Return the number of times that the string "code" appears anywhere in the given string,
     * except we'll accept any letter for the 'd', so "cope" and "cooe" count.
     */
    public int countCode(String str) {
        int count = 0;
        String pattern = "co[a-z]e";
        StringBuilder builder = new StringBuilder();
        if (str.length() < 4)
            return count;
        for (int i = 0; i < str.length() - 3; i++) {
            builder.append(str.substring(i, i + 4));
            if (builder.toString().matches(pattern))
                count++;
            builder.setLength(0);
        }
        return count;
    }

    /**
     * Given two strings, return true if either of the strings appears at the very end of the other string,
     * ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
     * Note: str.toLowerCase() returns the lowercase version of a string.
     */
    public boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        boolean test1 = a.length() >= b.length()
            && a.substring(a.length() - b.length()).equals(b);
        boolean test2 = a.length() < b.length()
            && a.equals(b.substring(b.length() - a.length()));
        return test1 || test2;
    }

    /**
     * Return true if the given string contains an appearance of "xyz" where the xyz is not
     * directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
     */
    public boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'y' && str.charAt(i + 2) == 'z') {
                if (i == 0 || str.charAt(i - 1) != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
     */
    public boolean bobThere(String str) {
        if (str.length() < 3)
            return false;
        final String pattern = "b.b";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length() - 2; i++) {
            builder.append(str.substring(i, i + 3));
            if (builder.toString().matches(pattern))
                return true;
            builder.setLength(0);
        }
        return false;
    }

    /**
     * We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y'
     * char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y'
     * can balance multiple 'x's. Return true if the given string is xy-balanced.
     */
    public boolean xyBalance(String str) {
        int n = str.length() - 1;
        boolean yFlag = false;
        while (n >= 0) {
            if (str.charAt(n) == 'y')
                yFlag = true;
            if (yFlag && str.charAt(n) == 'x')
                return true;
            if (!yFlag && str.charAt(n) == 'x')
                return false;
            n--;
        }
        return true;
    }

    /**
     * Given two strings, a and b, create a bigger string made of the first char of a,
     * the first char of b, the second char of a, the second char of b, and so on.
     * Any leftover chars go at the end of the result.
     */
    public String mixString(String a, String b) {
        String shorter = a.length() > b.length() ? b : a;
        String longer = a.length() > b.length() ? a : b;

        StringBuilder sb = new StringBuilder(a.length() + b.length());

        for (int i = 0; i < shorter.length(); i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }

        // add leftover chars
        sb.append(longer.substring(shorter.length()));

        return sb.toString();
    }

    /**
     * Given a string and an int n, return a string made of n repetitions of the last n characters
     * of the string. You may assume that n is between 0 and the length of the string, inclusive.
     * repeatEnd("Hello", 3) → "llollollo"
     * repeatEnd("Hello", 2) → "lolo"
     * repeatEnd("Hello", 1) → "o"
     */
    public String repeatEnd(String str, int n) {
        String string = str.substring(str.length() - n);
        var joiner = new StringJoiner("");
        for (int i = 0; i < n; i++) {
            joiner.add(string);
        }
        return joiner.toString();
    }

    /**
     * Given a string and an int n, return a string made of the first n characters of the string,
     * followed by the first n-1 characters of the string, and so on. You may assume that n is
     * between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
     * repeatFront("Chocolate", 4) → "ChocChoChC"
     * repeatFront("Chocolate", 3) → "ChoChC"
     * repeatFront("Ice Cream", 2) → "IcI"
     */
    public String repeatFront(String str, int n) {
        var result = new StringBuilder();
        for(int i = 0; i <= n; i++) {
            result.append(str, 0, n - i);
        }
        return result.toString();
    }

    /**
     * Given two strings, word and a separator sep, return a big string made of count
     * occurrences of the word, separated by the separator string.
     * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
     * repeatSeparator("This", "And", 2) → "ThisAndThis"
     * repeatSeparator("This", "And", 1) → "This"
     */
    public String repeatSeparator(String word, String sep, int count) {
        StringJoiner joiner = new StringJoiner(sep);
        for (int i = 0; i < count; i++) {
            joiner.add(word);
        }
        return joiner.toString();
    }

}
