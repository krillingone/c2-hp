/**
 * 请编码实现动物世界的继承关系∶
 * 动物( Animal )具有属性：身高、体重；具有行为︰吃( eat )﹑睡觉( sleep )
 * 动物包括︰兔子(Rabbit )、老虎( Tiger )
 * 这些动物吃的行为各不相同（兔子吃草，老虎吃肉）但睡觉的行为是一致的。
 */

public class Task_Additional {
    public static void main(String[] args) {
        Animal animal = new Animal(1, 1);
        Rabbit rabbit = new Rabbit(1, 1);
        Tiger tiger = new Tiger(1, 1);

        System.out.println("====animal====");
        animal.eat();
        animal.sleep();

        System.out.println("====rabbit====");
        rabbit.eat();
        rabbit.sleep();

        System.out.println("====tiger====");
        tiger.eat();
        rabbit.sleep();
    }
}

class Animal {
    private double height;
    private double weight;

    public Animal(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public void eat() {
        System.out.println("恰饭");
    }

    public void sleep() {
        System.out.println("zzzZZZ");
    }
}

class Rabbit extends Animal {
    public Rabbit(double height, double weight) {
        super(height, weight);
    }

    @Override
    public void eat() {
        System.out.println("兔子🐇恰草");
    }
}

class Tiger extends Animal {
    public Tiger(double height, double weight) {
        super(height, weight);
    }

    @Override
    public void eat() {
        System.out.println("老虎🐅恰肉");
    }
}
