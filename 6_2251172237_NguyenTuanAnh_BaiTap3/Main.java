package Btap3;

abstract class Vehicle {
    public abstract int getMaxSpeed();
}

class Car extends Vehicle {
    @Override
    public int getMaxSpeed() {
        return 200;
    }
}

class Bicycle extends Vehicle {
    @Override
    public int getMaxSpeed() {
        return 30;
    }
}

abstract class VehicleFactory {
    public abstract Vehicle createVehicle();

    public void print() {
        System.out.println("Factory: " + this.getClass().getSimpleName() + " đang tạo phương tiện.");
    }
}

class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BicycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bicycle();
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory bicycleFactory = new BicycleFactory();

        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = carFactory.createVehicle();
        vehicles[1] = bicycleFactory.createVehicle();

        carFactory.print();       
        bicycleFactory.print();   

        for (Vehicle v : vehicles) {
            System.out.println("Tốc độ tối đa: " + v.getMaxSpeed());
        }
    }
}
