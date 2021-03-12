import java.util.InputMismatchException;
import java.util.Scanner;

public class Task01_NumReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(reverseNum(num));
    }

    /**
     * 把传入数绝对值，并取出符号，
     * 使用StringBuilder的reverse方法简简单单的做一个字符串反转，
     * 然后将结果转int，乘以符号返回
     *
     * 错误日志：StringBuilder构造方法传入的参数只能是String，不然就是空
     * @param num
     * @return
     */
    public static int reverseNum(int num) {
        int sign = num > 0 ? 1 : -1;
        StringBuilder numSb = new StringBuilder();
        numSb.append(Math.abs(num));
        numSb.reverse();
        try {
            return Integer.parseInt(numSb.toString()) * sign;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
