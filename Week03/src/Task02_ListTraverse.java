import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Task02_ListTraverse {
    public static void main(String[] args) {
        Employee[] employees = {new Employee(1, "Joe", 70000, "3"),
                                new Employee(2, "Henry", 80000, "4"),
                                new Employee(3, "Sam", 60000),
                                new Employee(4, "Max",90000)};

        List<List<java.io.Serializable>> employeesInfoList = new ArrayList<>();
        for (Employee employee: employees) {
            employeesInfoList.add(employee.getInfo());
        }

        System.out.println("+----+-------+--------+-----------+");
        System.out.println("| Id | Name  | Salary | ManagerId |");
        System.out.println("+----+-------+--------+-----------+");
        for (List<Serializable> info : employeesInfoList) {
            System.out.printf("| %-2d | %-5s | %-6d | %-9s |\n",
                    info.get(0), info.get(1), info.get(2), info.get(3));
        }
        System.out.println("+----+-------+--------+-----------+");
    }
}

class Employee {
    private int Id;
    private String Name;
    private int Salary;
    private String ManagerId;

    public Employee(int id, String name, int salary) {
        Id = id;
        Name = name;
        Salary = salary;
        ManagerId = "NULL";
    }

    public Employee(int id, String name, int salary, String managerId) {
        Id = id;
        Name = name;
        Salary = salary;
        ManagerId = managerId;
    }

    public List<java.io.Serializable> getInfo() {
        List<java.io.Serializable> info = new ArrayList<>();
        info.add(Id);
        info.add(Name);
        info.add(Salary);
        info.add(ManagerId);

        return info;
    }
}
