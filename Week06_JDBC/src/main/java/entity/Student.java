package entity;

public class Student {

    private String SNO;
    private String Name;
    private Integer Age;
    private String College;

    public Student(String SNO, String name, Integer age, String college) {
        this.SNO = SNO;
        Name = name;
        Age = age;
        College = college;
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    @Override
    public String toString() {
        return SNO +", " + Name + ", " + Age +", " + College;
    }
}

