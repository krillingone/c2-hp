import java.util.Scanner;

public class Task02_LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("strs = ");
        String[] strs = in.nextLine()
                .replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .split(",");

        System.out.println(getCommonPrefix(strs));

    }

    public static String getCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();

        // 纵向扫描
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
