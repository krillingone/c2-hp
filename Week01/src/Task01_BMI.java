import java.util.Scanner;

/**
 * 请用 if ... else 编写一个程序，用于计算体质指数 BMI，并打印结果。
 * BMI = 体重(kg)除以身高(m)的平方
 */

public class Task01_BMI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double BMI, height, weight;

        System.out.print("输入体重(kg): ");
        weight = in.nextDouble();

        System.out.print("输入身高(m):  ");
        height = in.nextDouble();

        BMI = calcBMI(weight, height);

//        System.out.println(BMI);
        if (BMI < 18.5)
            System.out.println("过轻");
        else if (BMI >= 18.5 && BMI < 25)
            System.out.println("正常");
        else if (BMI >= 25 && BMI < 28)
            System.out.println("过重");
        else if (BMI >= 28 && BMI < 32)
            System.out.println("肥胖");
        else
            System.out.println("非常肥胖");
    }

    public static double calcBMI(double weight, double height) {
        return weight / Math.pow(height, 2);
    }
}
