import java.util.Arrays;

public class Task02_Ladder {
    public static void main(String[] args) {
        int ladders = 3;
        int maxStep = 2;

//        System.out.println(stepCount(ladders, maxStep));
        System.out.println(stepCountOnce2(ladders));
    }

    public static int stepCount(int ladders, int maxStep) {
        int steps = 0;
        if (ladders == 0) {
            return 1;
        }
        if (ladders >= maxStep) {
            for (int i = 1; i <= maxStep ; i++) {
                steps += stepCount(ladders - i, maxStep);
            }
        } else {
            steps = stepCount(ladders, ladders);
        }
        return steps;
    }

    public static int stepCountOnce2(int ladders) {
        int[] steps = new int[ladders + 1];
        steps[0] = 1;
        steps[1] = 1;
        if (ladders >= 2) {
            for (int i = 2; i < ladders + 1; i++) {
                steps[i] = steps[i - 1] + steps[i - 2];
            }
        }
        return steps[ladders];
    }
}
