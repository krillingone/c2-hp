public class Task05_MaxLengthOf1 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int maxLen = 0;
        int thisLen = 0;
        for (int num : nums) {
            if (num == 1) {
                thisLen += 1;
            } else {
                maxLen = Math.max(thisLen, maxLen);
                thisLen = 0;
            }
        }
        return Math.max(thisLen, maxLen);
    }
}
