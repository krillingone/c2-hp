import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task02_1_SpirallyGet {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1}, {2}, {3}, {4}};
//        int[][] matrix = {};
//        int[][] matrix = null;
        List<Integer> result = getSpiral(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 把大矩阵看作一圈又一圈的不可描述，然后转圈圈遍历，一层一层的遍历，把遍历的添加进结果集
     * @param matrix
     * @return
     */
    public static List<Integer> getSpiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int yl = matrix.length;    // 横轴
        int xl = matrix[0].length;    // 竖轴

        int tire = (Math.min(yl, xl) + 1) / 2;
        int i = 0;    // 层数
        // →
        while (i < tire) {
            for (int j = i; j < xl - i; j++) {
                result.add(matrix[i][j]);
            }
            // ↓
            for (int j = i + 1; j < yl - i; j++) {    // ＋1是跳过已经走过的那个
                result.add(matrix[j][xl - i - 1]);
            }
            // ←
            for (int j = xl - 1 - i - 1; (j >= i) && (yl - 1 - i != i); j--) {
                result.add(matrix[yl - 1 - i][j]);
            }
            // ↑
            for (int j = yl - 1 - i - 1; (j > i) && (xl - 1 - i != i); j--) {
                result.add(matrix[j][i]);
            }
            i++;
        }

        return result;
    }
}
