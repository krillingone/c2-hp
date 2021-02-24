import java.util.*;

public class Task07_LetterVariants {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultLists = classifyLetterVariants(strs);
        System.out.println(Arrays.toString(resultLists.toArray()));
    }

    /**
     * 使用map映射，将排序过后的字符串作为key，同加，不同新建一个AL
     * @param strs
     * @return
     */
    public static List<List<String>> classifyLetterVariants(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 字符串排序
            char[] charsOfStr = str.toCharArray();
            Arrays.sort(charsOfStr);    // 你妈的，烦死了，不能用链式
            String sortedStr = String.valueOf(charsOfStr);

            // 找到相同就获取已有的list，没有就新建
            // 然后把这个放到list里
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<String>());
            list.add(str);

            // 覆盖更新
            map.put(sortedStr, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
