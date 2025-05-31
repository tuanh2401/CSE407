package btap7;

interface IVehicle {
    double Speed();
    String Info();
    String getColor();
}

class Car implements IVehicle {
    @Override
    public double Speed() {
        return 120.0;
    }

    @Override
    public String Info() {
        return "Sedan Car";
    }

    @Override
    public String getColor() {
        return "Red";
    }
}

class Motorcycle implements IVehicle {
    @Override
    public double Speed() {
        return 150.0;
    }

    @Override
    public String Info() {
        return "Sport Bike";
    }

    @Override
    public String getColor() {
        return "Blue";
    }
}

class VehicleAbstraction {
    protected IVehicle vehicle;

    public VehicleAbstraction(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getSpeed() {
        return vehicle.Speed();
    }

    public String getInfo() {
        return vehicle.Info();
    }
    public String getColor() {
        return vehicle.getColor();
    }
}

class AdvancedVehicle extends VehicleAbstraction {
    private String premiumColor;

    public AdvancedVehicle(IVehicle vehicle) {
        super(vehicle);
        this.premiumColor = "Metallic";
    }

    @Override
    public double getSpeed() {
        return vehicle.Speed() * 1.2;
    }

    @Override
    public String getInfo() {
        return vehicle.Info() + " (Premium)";
    }
    public String getPremiumColor() {
        return premiumColor + " " + vehicle.getColor();
    }
}

public class Main {
    public static void main(String[] args) {
        IVehicle car = new Car();
        IVehicle bike = new Motorcycle();

        System.out.println("Basic Vehicles");
        VehicleAbstraction basicCar = new VehicleAbstraction(car);
        VehicleAbstraction basicBike = new VehicleAbstraction(bike);
        
        printVehicleInfo(basicCar);
        printVehicleInfo(basicBike);

        System.out.println("\nAdvanced Vehicles");
        AdvancedVehicle premiumCar = new AdvancedVehicle(car);
        AdvancedVehicle premiumBike = new AdvancedVehicle(bike);
        
        printVehicleInfo(premiumCar);
        printVehicleInfo(premiumBike);
        System.out.println("Premium Car Color: " + premiumCar.getPremiumColor());
        System.out.println("Premium Bike Color: " + premiumBike.getPremiumColor());
    }

    private static void printVehicleInfo(VehicleAbstraction vehicle) {
        System.out.println("Vehicle: " + vehicle.getInfo());
        System.out.println("Speed: " + vehicle.getSpeed() + " km/h");
        System.out.println("Color: " + vehicle.getColor());
    }
}