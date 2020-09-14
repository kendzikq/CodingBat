import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AP1 {

    public boolean scoresIncreasing(int[] scores) {
        int previous = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < previous)
                return false;
            previous = scores[i];
        }
        return true;
    }

    public boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100 && scores[i + 1] == 100) {
                return true;
            }
        }
        return false;
    }

    public boolean scoresClump(int[] scores) {
        for (int i = 0; i < scores.length - 2; i++) {
            if (scores[i + 2] - scores[i] <= 2) { //scores are sorted in increasing order
                return true;
            }
        }
        return false;
    }

    public int scoresAverage(int[] scores) {
        int half1 = average(scores, 0, scores.length / 2);
        int half2 = average(scores, scores.length / 2, scores.length);
        return Math.max(half1, half2);
    }

    public int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum + scores[i];
        }
        return sum > 0 ? sum / (end - start) : 0;
    }

    public int wordsCount(String[] words, int len) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == len) {
                counter++;
            }
        }
        return counter;
    }

    public String[] wordsFront(String[] words, int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<>();
        list = Arrays.stream(words).filter(x -> x.length() != len).collect(Collectors.toList());
        return list;
    }

    public boolean hasOne(int n) {
        while (n > 0) {
            if (n % 10 == 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

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

}
