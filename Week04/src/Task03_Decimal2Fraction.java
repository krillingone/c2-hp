import java.util.Scanner;

public class Task03_Decimal2Fraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double num = in.nextDouble();

        System.out.println(decimal2Fraction(num));
    }

    /**
     * 小数到分数
     * 将所给数通过移动小数点变成整数（分子），然后再与其所乘的数（分母）约简，即得到分子分母
     * @param num
     * @return
     */
    public static String decimal2Fraction(double num) {
        String strNum = String.valueOf(num);

        // 得到小数长度
        int decimalLength = strNum.split("\\.")[1].length();

        // molecular 分子 = 所给数 * 10^小数位数      denominator分母
        int molecular = (int) (num * Math.pow(10, decimalLength));
        int denominator = (int) Math.pow(10, decimalLength);

        int GCD = getGCD(molecular, denominator);

        return (molecular / GCD) + "/" + (denominator / GCD);
    }

    /**
     * 获取最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getGCD(int a, int b) {
        int large=0, small=0;
        if (a > b) {
            large = a;
            small = b;
        } else {
            large = b;
            small = a;
        }

        if (large % small != 0) {
            return getGCD(small, large % small);
        } else {
            return small;
        }
    }
}
