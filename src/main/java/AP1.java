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
}
