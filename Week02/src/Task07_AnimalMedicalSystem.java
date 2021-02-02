public class Task07_AnimalMedicalSystem {
    public static void main(String[] args) {
        Duck duck = new Duck("鸭子", "发烧", 2, "感冒");
        duck.showMsg();
        duck.showSymptom();
    }
}

abstract class Poultry {
    private String name;
    private String symptom;
    private int age;
    private String illness;

    public Poultry() {
        name = "";
        symptom = "";
        age = 0;
        illness = "";
    }

    public Poultry(String name, String symptom, int age, String illness) {
        this.name = name;
        this.symptom = symptom;
        this.age = age;
        this.illness = illness;
    }

    public abstract void showSymptom();

    public void showMsg() {
        System.out.printf("动物种类:%s,年龄:%d岁\n",this.name,this.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}

class Duck extends Poultry {

    public Duck() {
        super();
    }

    public Duck(String name, String symptom, int age, String illness) {
        super(name, symptom, age, illness);
    }

    @Override
    public void showSymptom() {
        System.out.printf("入院原因:%s\n症状为:%s",this.getIllness(),this.getSymptom());
    }
}