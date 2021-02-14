public class Task05_CostomException {
    public static void main(String[] args) {
        try {
            int result = divide(3, 0);
            System.out.println("divide result: " + result);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static int divide(int num1, int num2) throws MyException {
        if (num2 == 0) {
            throw new MyException("九年义务制教育的漏网之鱼？晓不晓得除数不为零？");
        }
        return num1 / num2;
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}