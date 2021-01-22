import java.util.ArrayList;

/**
 * 计算 1000 以内的水仙花数有多少个。
 * 所谓的“水仙花数”是指一个三位数其各位数字的方和等于该数本身
 */
public class Task02_NarcissisticNumber {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 100; i < 1000; i++) {
            if (calcSum(i)) {
                count ++;
                list.add(i);
            }
        }

        System.out.printf("100~1000水仙花数有 %d 个。\n", count);
        System.out.println(list.toString());
    }

    private static Boolean calcSum(int i) {
        int num1 = i/100;
        int num2 = (i%100) / 10;
        int num3 = (i % 100) % 10;
        int result_num = (int) (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3));
        return result_num == i;
    }
}
