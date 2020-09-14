import java.util.StringJoiner;

public class Warmup2 {

    public String stringTimes(String str, int n) {

        StringJoiner joiner = new StringJoiner("");
        for (int i = 0; i < n; i++)
            joiner.add(str);
        return joiner.toString();
    }

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

    public int countXX(String str) {
        int counter = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ("xx".equals(str.substring(i, i + 2))) {
                counter++;
            }
        }
        return counter;
    }

    boolean doubleX(String str) {
        int firstX = str.indexOf('x');
        if ((firstX + 1) != str.length() && firstX >= 0 && (str.charAt(firstX + 1) == 'x'))
            return true;
        return false;
    }

    public String stringBits(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 2) {
            result = result + str.charAt(i);
        }
        return result;
    }

    public String stringSplosion(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.substring(0, i + 1);
        }
        return result;
    }
}