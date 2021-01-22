import java.util.Scanner;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 */
public class Task03_ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;

        System.out.print("输入: ");
        str = in.nextLine();
        System.out.println("输出: " + reverse(str));
    }

    private static String reverse(String str) {
        int len = str.length();
        char[] strCharArray = str.toCharArray();
        char[] reversedStrCharArray = new char[len];
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            reversedStrCharArray[i] = strCharArray[j];
        }
        return String.valueOf(reversedStrCharArray);
    }
}
