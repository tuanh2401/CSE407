package Btap4;

public class Main {

    interface ICar {
        void output();
    }

    interface IBicycle {
        void output();
    }

    //ab factory
    interface VehicleFactory {
        ICar createCar();
        IBicycle createBicycle();
    }

    static class VNCar implements ICar {
        public void output() {
            System.out.println("VNCar: Tốc độ tối đa là 200 km/h");
        }
    }

    static class CNCar implements ICar {
        public void output() {
            System.out.println("CNCar: Tốc độ tối đa là 180 km/h");
        }
    }

    static class VNBicycle implements IBicycle {
        public void output() {
            System.out.println("VNBicycle: Tốc độ tối đa là 30 km/h");
        }
    }

    static class CNBicycle implements IBicycle {
        public void output() {
            System.out.println("CNBicycle: Tốc độ tối đa là 25 km/h");
        }
    }

    static class VNFactory implements VehicleFactory {
        public ICar createCar() {
            return new VNCar();
        }

        public IBicycle createBicycle() {
            return new VNBicycle();
        }
    }

    static class CNFactory implements VehicleFactory {
        public ICar createCar() {
            return new CNCar();
        }

        public IBicycle createBicycle() {
            return new CNBicycle();
        }
    }

    // Client
    static class Client {
        private VehicleFactory factory;

        public Client(VehicleFactory factory) {
            this.factory = factory;
        }

        public void someOperation() {
            ICar car = factory.createCar();
            IBicycle bicycle = factory.createBicycle();

            car.output();
            bicycle.output();
        }
    }

    public static void main(String[] args) {
        System.out.println("== Việt Nam Factory ==");
        Client clientVN = new Client(new VNFactory());
        clientVN.someOperation();

        System.out.println("\n== China Factory ==");
        Client clientCN = new Client(new CNFactory());
        clientCN.someOperation();
    }
}

