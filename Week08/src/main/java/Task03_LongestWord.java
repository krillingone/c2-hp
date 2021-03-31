import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task03_LongestWord {
    public static void main(String[] args) {
        String[] words = {"cat", "banana", "dog", "nana", "walk", "walker","dogwalker", "dogwalkerdog", "dogwalkercat"};
        System.out.println(solution(words));
    }
    // 检测word是否是由set里面的单词组成
    private static boolean isComposeWord(Set<String> set, String word) {
        // 这铁最后一个，意思是好歹返回一个
        if (word.length() == 0) {
            return true;
        }

        // 循环+递归一直查找，找到就算成功
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && isComposeWord(set, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static String solution(String[] words) {
        // 排序，大的在前，先遍历长的且字典小的，让第一个判断正确的返回就是正确结果
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                // 比字典，小
                return o1.compareTo(o2);
            } else {
                // 比长度，长
                return Integer.compare(o2.length(), o1.length());
            }
        });

        Set<String> set = new HashSet<>(Arrays.asList(words));
        // 遍历检测当前单词是不是组合单词，是的话直接返回
        for (String  word :words ) {
            set.remove(word);
            if (isComposeWord(set, word)) {
                return word;
            }
            set.add(word);
        }
        return "";
    }
}
