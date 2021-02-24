import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task03_GetNumFromString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println("Traverse  " + getNum(str).toString());
        System.out.println("Regex     " + getNumRegex(str).toString());
    }

    /**
     * 用数组遍历逐个提取数字
     * @param str 输入的字符串
     * @return 返回结果Integer数组列表
     */
    public static ArrayList<Integer> getNum(String str) {
        ArrayList<Integer> num_list = new ArrayList<>();
        str += "#";    // 结尾标志，当原串是数字时最后一个数不会上传

        int str_len = str.length();

        String temp = "";
        for (int i = 0; i < str_len; i++) {
            // 是数字就放到临时数字字符串temp中
            if (Character.isDigit(str.charAt(i))) {
                temp += str.charAt(i);
            } else {
                // 碰到非数字字符就上传临时数字字符串temp到ArrayList，并将temp清空
                if (!temp.equals("")) {    // 连续的非数字字符跳过
                    num_list.add(Integer.parseInt(temp));
                    temp = "";
                }
            }
        }

        return num_list;
    }

    /**
     * 用正则划分字符串，然后将匹配结果放入ArrayList返回
     * @param str 输入的字符串
     * @return 返回结果Integer数组列表
     */
    public static ArrayList<Integer> getNumRegex(String str) {
        // 匹配多个数字
        String regex = "\\d+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        // 拆到数组里
        ArrayList<Integer> num_list = new ArrayList<>();
        while (m.find()) {
            num_list.add(Integer.parseInt(m.group(0)));    // 匹配第一个子正则（本来就只有一个
        }

        return num_list;
    }
}
