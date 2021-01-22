import java.util.Scanner;

/**
 * 声明并测试一个复数类，其中包括 add()、reduce()、multiply()三种方法，分别实现两
 * 个复数的相加、相减、相乘，然后输出计算的结果。
 * 示例：（第一行输入两个数字分别表示第一个复数的实部和虚部、第二行输入的两个数字表
 * 示第二个复数的实部和虚部）
 * 输入：
 * 2 3
 * 1 2
 * 输出：
 * 两复数相加的结果为：3+5i
 * 两复数相减的结果为：1+i
 * 两复数相乘的结果为：-4+7i
 */
public class Task07_Plurality {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("输入: ");
        String[] input1 = in.nextLine().split(" ");
        String[] input2 = in.nextLine().split(" ");

        Plurality p1 = new Plurality(Integer.parseInt(input1[0]), Integer.parseInt(input1[1]));
        Plurality p2 = new Plurality(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]));

        System.out.println("两复数相加的结果为：" + p1.add(p2));
        System.out.println("两复数相减的结果为：" + p1.reduce(p2));
        System.out.println("两复数相乘的结果为：" + p1.multiply(p2));
    }
}

class Plurality {
    private int n1;
    private int n2;

    public Plurality(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public Plurality add(Plurality oP) {
        return new Plurality(this.n1 + oP.n1, this.n2 + oP.n2);
    }

    public Plurality reduce(Plurality oP) {
        return new Plurality(this.n1 - oP.n1, this.n2 - oP.n2);
    }

    public Plurality multiply(Plurality oP) {
        int newN1 = this.n1 * oP.n1 - this.n2 * oP.n2;
        int newN2 = this.n2 * oP.n1 + this.n1 * oP.n2;
        return new Plurality(newN1, newN2);
    }

    @Override
    public String toString() {
        if (this.n2 > 0) {
            return this.n1 + "+" + this.n2 + "i";
        } else if (this.n2 == 0) {
            return this.n1 + "";
        } else {
            return this.n1 + this.n2 + "i";
        }
    }
}
