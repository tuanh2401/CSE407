package Btap5;

interface VehicleBuilder {
    void reset();
    void setMaxSpeed(int speed);
    void setWheels(int number);
    Object getResult();
}
class Car {
    private int maxSpeed;
    private int wheels;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWheels() {
        return wheels;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{maxSpeed=" + maxSpeed + ", wheels=" + wheels + "}";
    }
}

class Bicycle {
    private int maxSpeed;
    private int wheels;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWheels() {
        return wheels;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Bicycle{maxSpeed=" + maxSpeed + ", wheels=" + wheels + "}";
    }
}

class CarBuilder implements VehicleBuilder {
    private Car car;

    @Override
    public void reset() {
        this.car = new Car();
    }

    @Override
    public void setMaxSpeed(int speed) {
        car.setMaxSpeed(speed);
    }

    @Override
    public void setWheels(int number) {
        car.setWheels(number);
    }

    @Override
    public Car getResult() { 
        return car;
    }
}

class BicycleBuilder implements VehicleBuilder {
    private Bicycle bicycle;

    @Override
    public void reset() {
        this.bicycle = new Bicycle();
    }

    @Override
    public void setMaxSpeed(int speed) {
        bicycle.setMaxSpeed(speed);
    }

    @Override
    public void setWheels(int number) {
        bicycle.setWheels(number);
    }

    @Override
    public Bicycle getResult() { 
        return bicycle;
    }
}

class Director {
    private VehicleBuilder builder;

    public void makeVehicle() {
        builder.reset();
    }

    public void makeCar() {
        builder = new CarBuilder();
        makeVehicle();
        builder.setMaxSpeed(200);
        builder.setWheels(4);
    }

    public void makeBicycle() {
        builder = new BicycleBuilder(); 
        makeVehicle();
        builder.setMaxSpeed(30);
        builder.setWheels(2);
    }

    public Object getResult() {
        return builder.getResult();
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.makeCar();
        Car car = (Car) director.getResult(); 
        System.out.println("Xe ô tô được tạo: " + car);

        // Tạo Bicycle
        director.makeBicycle();
        Bicycle bicycle = (Bicycle) director.getResult(); 
        System.out.println("Xe đạp được tạo: " + bicycle);
    }
}