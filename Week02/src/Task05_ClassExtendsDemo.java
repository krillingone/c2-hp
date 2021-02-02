public class Task05_ClassExtendsDemo {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Person person = new Person();

        System.out.println("Monkey: ");
        monkey.speak();
        System.out.println("Person: ");
        person.speak();
        person.think();
    }
}

class Monkey {
    public void speak() {
        System.out.println("咿咿呀呀……");
    }
}

class Person extends Monkey {
    @Override
    public void speak() {
        System.out.println("小样的，不错嘛！会说话了！");
    }

    void think() {
        System.out.println("别说话，认真思考！");
    }
}
