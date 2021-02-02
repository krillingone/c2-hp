import java.util.Arrays;
import java.util.Scanner;

public class Task01_MatrixRotate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读入，去除括号，划分
        System.out.print("matrix = ");
        String[] num_list = in.nextLine()
                .replace("[", "")
                .replace("]", "")
                .split(",");

        int d = (int)Math.sqrt(num_list.length);    // nxn矩阵，根据输入推维度
        int[][] matrix = new int[d][d];    // init

        // 将输入放到数组里
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                matrix[i][j] = Integer.parseInt(num_list[i * 3 + j]);
            }
        }

        matrix = rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static int[][] rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] rotated_matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int k = len - 1 - i;    // rotated_matrix的行是matrix的len-i-1列
                rotated_matrix[j][k] = matrix[i][j];
            }
        }
        return rotated_matrix;
    }
}
