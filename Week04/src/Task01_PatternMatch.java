import java.util.Scanner;

public class Task01_PatternMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String pattern = in.next();

        int loc = getPattrenLoction(str, pattern);
        System.out.println(loc);
    }

    /**
     * 获取匹配子串在原字符串的位置
     * @param str 原字符串
     * @param pattern 子串
     * @return >= 0：位置 ||||  < 0：无匹配
     */
    private static int getPattrenLoction(String str, String pattern) {
        int i = 0;
        int j = 0;

        char[] strChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();

        // 滑轨在父串一个个匹配
        while (i < str.length() && j < pattern.length()) {
            if (strChars[i] == patternChars[j]) {
                i++;
                j++;
            } else {
                i=i-j+1;
                j=0;
            }
        }

        // 如果说匹配完了，父串跑完，子串跑完（这个是肯定匹配），j与长度相同就是匹配上了
        if (j == pattern.length()) {
            return i-j;
        } else {
            return -1;
        }
    }
}
