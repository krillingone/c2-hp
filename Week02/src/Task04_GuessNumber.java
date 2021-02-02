import java.util.Scanner;

public class Task04_GuessNumber {

    static Game game = new Game();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int guess_num;

        System.out.println("欢迎来到猜字游戏，请输入一个数: ");
        cycle:
        while (true) {
            guess_num = in.nextInt();
            switch (guess(guess_num)) {
                case -1 -> System.out.println("猜的有点小，再试一下吧!");
                case 1 -> System.out.println("猜大了噢，再试—下吧!");
                case 0 -> {
                    System.out.println("恭喜你，猜对了!");
                    break cycle;    // 跳出while循环
                }
            }
        }
    }

    public static int guess(int guess_num) {
        return Integer.compare(guess_num, game.getV());
    }
}

class Game {
    private final int v;

    public Game() {
        v = 100;
    }

    public Game(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }
}