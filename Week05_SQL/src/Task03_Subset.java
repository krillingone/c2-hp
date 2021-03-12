import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Task03_Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
//        result = subset(nums);

        traceBack(0, nums, result, new ArrayList<Integer>());
        System.out.println(result);
    }

    /**
     * 用那个迭代 二进制的方法解决
     * 例：000->[-,-,-] 001->[-,-,*] 011->[-,*,*]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subset(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1<<nums.length); i++) {
            tmp.clear();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(tmp));
        }
        return result;
    }

    /**
     * 回溯递归方法，深度优先dfs
     * @param start 起始位置
     * @param nums 原列表
     * @param rlt 传入的结果列表
     * @param tmp
     */
    public static void traceBack(int start, int[] nums, List<List<Integer>> rlt, ArrayList<Integer> tmp) {
        rlt.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            traceBack(i+1, nums, rlt, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
