/**
 * 编写一个银行账户类，类的构成包括：
 * 数据成员：用户的账户名称、用户的账户余额;
 * 方法包括：开户（设置账户名称及余额, 利用构造方法完成)；查询余额。
 */
public class Task06_Bank {
    public static void main(String[] args) {
        BankAccount bc = new BankAccount("a00001", 233333.0);
        System.out.println("余额:" + bc.queryBalance());
    }
}

class BankAccount {
    private String id;
    private double balance;

    public BankAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public double queryBalance() {
        return this.balance;
    }
}
