import java.util.Scanner;

public class Task01_DecimalBin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        System.out.println("\"" + solution(num) + "\"");
    }

    public static String solution(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        sb.append('.');
        for (int i = 0; i < 30; i++) {
            if (num == 0) return sb.toString();
            num *= 2;
            if (num >= 1) {
                sb.append('1');
                num -= 1;
            } else if (num > 0 && num < 1) {
                sb.append('0');
            }
        }
        return "ERROR";
    }

}
