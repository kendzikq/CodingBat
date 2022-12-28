public class String3 {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y'
     * in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive).
     * We'll say that a y or z is at the end of a word if there is not an alphabetic letter
     * immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * countYZ("fez day") → 2
     * countYZ("day fez") → 2
     * countYZ("day fyyyz") → 2
     */
    public int countYZ(String str) {
        int count = 0;
        str = str.toLowerCase();
        char c = str.charAt(0);
        for (int i = 1; i <= str.length() - 1; i++) {
            if (c == 'z' || c == 'y') {
                c = str.charAt(i);
                if (!Character.isLetter(c))
                    count++;
            } else
                c = str.charAt(i);
        }
        if (c == 'z' || c == 'y')
            count++;
        return count;
    }


    /**
     * Given two strings, base and remove, return a version of the base string where all instances
     * of the remove string have been removed (not case sensitive). You may assume that the remove
     * string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * withoutString("Hello there", "llo") → "He there"
     * withoutString("Hello there", "e") → "Hllo thr"
     * withoutString("Hello there", "x") → "Hello there"
     */
    public String withoutString(String base, String remove) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            if (i <= base.length() - remove.length() && base.substring(i, i + remove.length()).equalsIgnoreCase(remove)) {
                i += remove.length() - 1;
            } else {
                result.append(base.charAt(i));
            }
        }
        return result.toString();
    }


    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string
     * is equal to the number of appearances of "not" anywhere in the string (case sensitive).
     * equalIsNot("This is not") → false
     * equalIsNot("This is notnot") → true
     * equalIsNot("noisxxnotyynotxisi") → true
     */
    public boolean equalIsNot(String str) {
        final String notStr = "not";
        final String isStr = "is";

        if (str == null) {
            return false;
        }

        int isCount = 0;
        int notCount = 0;

        for (int i = 0; i <= str.length() - isStr.length(); i++) {
            if (isStr.equals(str.substring(i, i + isStr.length()))) {
                isCount++;
            }
            if (i <= str.length() - notStr.length() && notStr.equals(str.substring(i, i + notStr.length()))) {
                notCount++;
            }
        }
        return isCount == notCount;
    }

}
