public class Warmup1 {

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation)
            return true;
        return false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile ^ bSmile)
            return false;
        return true;
    }

    public int sumDouble(int a, int b) {
        int sum = a + b;
        if (a == b) {
            return 2 * sum;
        }
        return sum;
    }

    public int diff21(int n) {
        if (n <= 21)
            return 21 - n;
        return (n - 21) * 2;

    }

    public boolean parrotTrouble(boolean talking, int hour) {
        return (talking && (hour < 7 || hour > 20));
    }

    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a + b == 10;
    }
}
