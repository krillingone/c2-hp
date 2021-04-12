import java.util.HashSet;
import java.util.Set;

public class Task02 {
    public static void main(String[] args) {
        String a="0100110001010001";
        Set<String> set = new HashSet<>();

        // set，卡尺不断add substring，不重复
        for (int i = 0; i < a.length(); i++) {
            for (int j = i+1; j <= a.length(); j++) {
                set.add(a.substring(i,j));
            }
        }
        System.out.println(set.size());
    }
}
