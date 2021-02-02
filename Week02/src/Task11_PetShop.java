import java.util.LinkedList;

public class Task11_PetShop {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        shop.add(new Cat("波斯猫", "喵喵", 1));
        shop.add(new Cat("暹罗猫", "喵喵", 2));
        shop.add(new Cat("田园猫", "旺财", 3));
        shop.add(new Dog("松狮", "旺财", 4));
        shop.add(new Dog("中华田园犬", "旺财", 1));
        shop.delete(new Fish("锦鲤", "红发", 1));

        Link<Pet> all = shop.searchByKind("猫");
        for (Pet pet : all.getList()) {
            System.out.println(pet);
        }
        System.out.println("======================");
        all = shop.searchByName("旺财");
        for (Pet pet : all.getList()) {
            System.out.println(pet);
        }
        System.out.println("======================");
        all = shop.searchByAge(1);
        for (Pet pet : all.getList()) {
            System.out.println(pet);
        }
    }
}

class PetShop {
    private Link<Pet> pets = new Link<>();

    public void add(Pet pet) {
        pets.add(pet);
    }

    public void delete(Pet pet) {
        pets.remove(pet);
    }

    public Link<Pet> searchByKind(String keywd) {
        Link<Pet> result = new Link<>();
        for (Pet pet : pets.getList()) {
            if (pet.getKind().contains(keywd)) {
                result.add(pet);
            }
        }
        return result;
    }

    public Link<Pet> searchByName(String keywd) {
        Link<Pet> result = new Link<>();
        for (Pet pet : pets.getList()) {
            if (pet.getName().contains(keywd)) {
                result.add(pet);
            }
        }
        return result;
    }

    public Link<Pet> searchByAge(int age) {
        Link<Pet> result = new Link<>();
        for (Pet pet : pets.getList()) {
            if (pet.getAge() == age) {
                result.add(pet);
            }
        }
        return result;
    }
}

class Link<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void add(T t) {
        list.add(t);
    }

    public void remove(T t) {
        list.remove(t);
    }

    public LinkedList<T> getList() {
        return list;
    }
}

interface Pet {
    public String  getKind();
    public String getName();
    public int getAge();
}

class Cat implements Pet {
    private String kind;
    private String name;
    private int age;

    public Cat() {
        this.kind = "unknown";
        this.name = "unknown";
        this.age = -1;
    }

    public Cat(String kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "猫的种类：" + kind +
                ", 名字：" + name +
                ", 年龄：" + age;
    }
}

class Dog implements Pet {
    private String kind;
    private String name;
    private int age;

    public Dog() {
        this.kind = "unknown";
        this.name = "unknown";
        this.age = -1;
    }

    public Dog(String kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "狗的种类：" + kind +
                ", 名字：" + name +
                ", 年龄：" + age;
    }
}

class Fish implements Pet {
    private String kind;
    private String name;
    private int age;

    public Fish() {
        this.kind = "unknown";
        this.name = "unknown";
        this.age = -1;
    }

    public Fish(String kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "鱼的种类：" + kind +
                ", 名字：" + name +
                ", 年龄：" + age;
    }
}