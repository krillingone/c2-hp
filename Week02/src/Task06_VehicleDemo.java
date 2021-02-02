public class Task06_VehicleDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(1, 15);
        Car car = new Car(3);
        Truck truck = new Truck(4, 6000);

        System.out.println(vehicle);
        System.out.println("------------------------------");
        System.out.println(car);
        System.out.println("------------------------------");
        System.out.println(truck);
    }
}

class Vehicle {
    int wheels;
    double weight;

    public Vehicle() {
        wheels = 0;
        weight = 0;
    }

    public Vehicle(int wheels, int weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "车轮的个数是："+ wheels + "    车重：" + weight;
    }
}

class Car extends Vehicle {
    int max_loader;
    int loader;

    public Car(int loader) {
        wheels = 4;
        weight = 1150.0;
        max_loader = 6;
        this.loader = loader;
    }

    @Override
    public String toString() {
        String s = "车轮的个数是："+ wheels + "    车重：" + weight + "\n";
        s += "这是一辆小车，能载"+ max_loader + "人，实载" + loader + "人";
        if (loader > max_loader)
            s += "，你超员了！！！";

        return s;
    }
}

class Truck extends Vehicle{
    int max_loader;
    int loader;
    int max_payload;
    double payload;

    public Truck(int loader, double payload) {
        wheels = 6;
        weight = 15000.0;
        max_loader = 3;
        max_payload = 5000;
        this.loader = loader;
        this.payload = payload;
    }

    @Override
    public String toString() {
        String s = "车轮的个数是："+ wheels + "    车重：" + weight + "\n";
        s += "这是一辆卡车，能载"+ max_loader + "人，实载" + loader + "人";
        if (loader > max_loader)
            s += "，你超员了！！！\n";
        else
            s += "\n";
        s += "这是一辆卡车，核载"+ max_payload + "kg，你已装载" + payload + "kg";
        if (payload > max_payload)
            s += "，你超载了！！！";

        return s;
    }
}