package btap6;

interface VehicleInterface {
    void accelerate();
    void brake();
}

class CarService {
    public void pressGas() {
        System.out.println("CarService: Hãy nhấn chân gaaaa !!!");
    }

    public void hitBrakes() {
        System.out.println("CarService: Hãy đạp phanhhh !!!");
    }
}

class CarServiceAdapter implements VehicleInterface {
    private CarService adaptee;

    public CarServiceAdapter(CarService service) {
        this.adaptee = service;
    }

    @Override
    public void accelerate() {
        adaptee.pressGas();
    }

    @Override
    public void brake() {
        adaptee.hitBrakes();
    }
}

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        VehicleInterface vehicle = new CarServiceAdapter(carService);

        vehicle.accelerate();
        vehicle.brake();
    }
}