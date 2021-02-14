import java.util.*;

public class Task03_StringDeduplicate {
    public static void main(String[] args) {
        // input
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // 拆分转换
        HashSet<String> set = new HashSet<>(Arrays.asList(input.split("")));

        System.out.println(Arrays.toString(set.toArray()));
    }
}
