import java.util.Arrays;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        int needed = (arr.length + 1) / 2;
        int count = 0;
        int changeCount = 0;

        for (int num : arr) {
            if ((Math.sqrt(num) % 1) == 0)
                count++;
            // 1*1=2 2*2=4，那这玩意儿是没法+1  -1都开方的
            if ((Math.sqrt(num+1) % 1) == 0)
                changeCount++;
            if ((Math.sqrt(num-1) % 1) == 0)
                changeCount++;
        }

        // 康康是不是有足够的黑幕操作空间
        if (count + changeCount < needed) {
            System.out.println("没办法。。。");
        } else {
            System.out.println(needed - count);
        }

    }
}
