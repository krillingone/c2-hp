import java.util.*;
import java.util.stream.Collectors;

// 给定一个集合，里面有 1000 个整数，请找出重复次数最多的那 10 个数
public class Task01_RepeatMost10 {
    public static void main(String[] args) {
        Random random = new Random(12315);
        int n = 1000;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = random.nextInt(100);
        }

        long start = System.nanoTime();
        int[] result = solutionHashMapSort(list);    //54318600
//        int[] result = solutionHashMapFind(list);    // 2006500
        long end = System.nanoTime();
        System.out.println(Arrays.toString(result) + "\ncost:" + (end - start));
    }

    public static int[] solutionHashMapSort(int[] list) {
        int[] result = new int[10];

        Map<Integer, Integer> map = new HashMap<>(1000);
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // jdk8
        LinkedHashMap<Integer,Integer> sortedMap;
        sortedMap = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // 降序
                .collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        int countFlag = 0;
        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (countFlag == 10)
                break;
            result[countFlag] = entry.getKey();
            countFlag ++;
        }

        return result;
    }

    public static int[] solutionHashMapFind(int[] list) {
        int[] result = new int[10];

        Map<Integer, Integer> map = new HashMap<>(1000);
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);

        for (int i = 0; i < 10; i++) {
            int key = findMax(map);
            result[i] = key;
            map.remove(key);
        }

        return result;
    }

    /**
     * 从map里找到最大的那个value的key，但是必须要遍历完
     * @param map map
     * @return map最靠后的最大
     */
    private static int findMax(Map<Integer, Integer> map) {
        int key = -1;
        int maxValue = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= maxValue) {
                maxValue = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

}
