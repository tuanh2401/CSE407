package btap9;

interface SpeedStrategy {
 int getMaxSpeed();
 String getColor();
}

class CarStrategy implements SpeedStrategy {
 private String color;

 public CarStrategy(String color) {
     this.color = color;
 }

 @Override
 public int getMaxSpeed() {
     return 200;
 }

 @Override
 public String getColor() {
     return color;
 }
}

class BicycleStrategy implements SpeedStrategy {
 private String color;

 public BicycleStrategy(String color) {
     this.color = color;
 }

 @Override
 public int getMaxSpeed() {
     return 40;
 }

 @Override
 public String getColor() {
     return color;
 }
}

class Context {
 private SpeedStrategy strategy;

 public void setStrategy(SpeedStrategy strategy) {
     this.strategy = strategy;
 }

 public int getMaxSpeed() {
     if (strategy != null) {
         return strategy.getMaxSpeed();
     }
     return 0;
 }

 public String getVehicleColor() {
     if (strategy != null) {
         return strategy.getColor();
     }
     return "Unknown";
 }
}

public class main {
 public static void main(String[] args) {
     Context context = new Context();
     SpeedStrategy car = new CarStrategy("Đỏ");
     context.setStrategy(car);
     System.out.println("Tốc độ tối đa của ô tô: " + context.getMaxSpeed());
     System.out.println("Màu sắc của ô tô: " + context.getVehicleColor());
     SpeedStrategy bicycle = new BicycleStrategy("Xanh");
     context.setStrategy(bicycle);
     System.out.println("Tốc độ tối đa của xe đạp: " + context.getMaxSpeed());
     System.out.println("Màu sắc của xe đạp: " + context.getVehicleColor());
 }
}

