package btap8;

interface Mediator {
    void notify(Object sender);
}

class Car {
    private Mediator m;

    public Car(Mediator m) {
        this.m = m;
    }

    public int getMaxSpeed() {
        System.out.println("Xe hơi: Tôi đang kiểm tra tốc độ tối đa.");
        m.notify(this);
        return 200;
    }
}

class Bicycle {
    private Mediator m;

    public Bicycle(Mediator m) {
        this.m = m;
    }

    public int getMaxSpeed() {
        System.out.println("Xe đạp: Tôi đang kiểm tra tốc độ tối đa.");
        m.notify(this);
        return 40;
    }
}

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
        System.out.println("Người trung gian: Đã nhận yêu cầu xem tốc độ tối đa từ Xe hơi.");
    }

    private void reactOnBicycle() {
        System.out.println("Người trung gian: Đã nhận yêu cầu xem tốc độ tối đa từ Xe đạp.");
    }

    public static void main(String[] args) {
        MediatorVehicle mediator = new MediatorVehicle();

        Car car = new Car(mediator);
        Bicycle bicycle = new Bicycle(mediator);

        mediator.setComponentCar(car);
        mediator.setComponentBicycle(bicycle);

        System.out.println("Tốc độ tối đa xe hơi: " + car.getMaxSpeed() + " km/h");
        System.out.println("Tốc độ tối đa xe đạp: " + bicycle.getMaxSpeed() + " km/h");
    }
}
