import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的
 * 相对顺序。
 * 示例：
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */

public class Task04_MoveZero2Tail {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.print("输入: ");
        input = in.nextLine();
        input = input.substring(1, input.length() - 1);

        String[] strArr = input.split(",");
        int[] nums = new int[strArr.length];

        // 初始化的int数组全0，所以就把非0一个挨一个放进去就好
        int loc=0;
        for (String s: strArr) {
            if (!s.equals("0")) {
                nums[loc] = Integer.parseInt(s);
                loc++;
            }
        }
        System.out.println("输出: " + Arrays.toString(nums).replace(" ", ""));
    }
}
