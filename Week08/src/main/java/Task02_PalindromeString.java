public class Task02_PalindromeString {

    public static void main(String[] args) {
        System.out.println(solution("abcda"));
    }

    public static boolean solution(String str) {
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return minusSolution(str, low+1, high) || minusSolution(str, low, high-1);
            }
        }
        return true;
    }

    private static boolean minusSolution(String str, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
