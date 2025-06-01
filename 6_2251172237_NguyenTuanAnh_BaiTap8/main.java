package btap8;

// Interface Mediator
interface Mediator {
    void notify(Object sender);
}

// Lớp Car
class Car {
    private Mediator m;

    public Car(Mediator m) {
        this.m = m;
    }

    public int getMaxSpeed() {
        System.out.println("Car: Tốc độ tối đa.");
        m.notify(this);
        return 200;
    }
}

// Lớp Bicycle
class Bicycle {
    private Mediator m;

    public Bicycle(Mediator m) {
        this.m = m;
    }

    public int getMaxSpeed() {
        System.out.println("Bicycle: Tốc độ tối đa");
        m.notify(this);
        return 40;
    }
}

// Lớp MediatorVehicle
class MediatorVehicle implements Mediator {
    private Car componentCar;
    private Bicycle componentBicycle;

    public void setComponentCar(Car car) {
        this.componentCar = car;
    }

    public void setComponentBicycle(Bicycle bicycle) {
        this.componentBicycle = bicycle;
    }

    @Override
    public void notify(Object sender) {
        if (sender instanceof Car) {
            reactOnCar();
        } else if (sender instanceof Bicycle) {
            reactOnBicycle();
        }
    }

    private void reactOnCar() {
        System.out.println("Mediator: Đã nhận yêu cầu xem tốc độ tối đa từ Car.");
    }

    private void reactOnBicycle() {
        System.out.println("Mediator: Đã nhận yêu cầu xem tốc độ tối đa từ Bicycle.");
    }
}

class main {
    public static void main(String[] args) {
        MediatorVehicle mediator = new MediatorVehicle();

        Car car = new Car(mediator);
        Bicycle bicycle = new Bicycle(mediator);

        mediator.setComponentCar(car);
        mediator.setComponentBicycle(bicycle);

        System.out.println("Tốc độ tối đa của car: " + car.getMaxSpeed() + " km/h");
        System.out.println("Tốc độ tối đa của bicycle: " + bicycle.getMaxSpeed() + " km/h");
    }
}
