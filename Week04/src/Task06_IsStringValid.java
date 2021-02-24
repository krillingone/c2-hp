import java.util.Stack;

public class Task06_IsStringValid {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "[()]";
        String s3 = "[(])";
        String s4 = "[](){}";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.size() == 0) {    // 空栈就是开始或者前面的消完了，直接加
                stack.push(c);
            } else if (isBracketsCouple(stack.peek(), c)) {    // 是一对就把前一个弹出来，peek是不回删除栈顶的
                stack.pop();
            } else {    // 不匹配就压进去
                stack.push(c);
            }
        }
        return stack.size()==0;    // 只有空栈才说明消消乐满分
    }

    /**
     * 判断c1，c2是不是一对括号
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isBracketsCouple(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'));
    }
}
