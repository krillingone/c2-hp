import java.util.HashMap;
import java.util.Scanner;

public class Task02_FirstNonRepetitiveChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        int result = getFirstUniqueChar(str);

        System.out.println(result);
    }

    public static int getFirstUniqueChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        //map计数
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);    // getOrDefault 有就用key的值，没有就用默认值
        }

        // 一个一个来那个是第一个计数为1的就返回那个的location
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
