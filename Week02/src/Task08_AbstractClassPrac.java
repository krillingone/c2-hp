public class Task08_AbstractClassPrac {
    public static void main(String[] args) {
        C c = new C();
        c.showA();
        c.showB();
        c.showC();
    }
}

abstract class A {
    private int numa = 10;

    abstract void showA();

    public int getNuma() {
        return numa;
    }
}

abstract class B extends A {
    private int numb = 20;

    public int getNumb() {
        return numb;
    }

    abstract void showB();
}

class C extends B {

    private int numc = 30;

    @Override
    void showA() {
        System.out.println("A类中numa:" + this.getNuma());
    }

    @Override
    void showB() {
        System.out.println("B类中numb:" + this.getNumb());
    }

    void showC() {
        System.out.println("C类中numc:" + numc);
    }

}