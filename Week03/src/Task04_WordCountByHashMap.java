import java.util.HashMap;
import java.util.Scanner;

public class Task04_WordCountByHashMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // 拆
        String[] list = input.split("");

        HashMap<String, Integer> map = new HashMap<>();

        // 遍历，包含+1，不包添加
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        // 打印结果
//        System.out.println(map.toString());
        for (String s: map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
    }
}
