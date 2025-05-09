package Btap2;
//Lớp cha
abstract class Vehicle {
 public abstract int getMaxSpeed();
}

//Lớp con Car
class Car extends Vehicle {
 @Override
 public int getMaxSpeed() {
     return 200;
 }
}

//Lớp con Bicycle
class Bicycle extends Vehicle {
 @Override
 public int getMaxSpeed() {
     return 30;
 }
}

//Lớp kiểm tra nguyên lý LSP
public class Main {
 public static void main(String[] args) {
     Vehicle[] vehicles = new Vehicle[2];
     vehicles[0] = new Car();
     vehicles[1] = new Bicycle();

     for (Vehicle v : vehicles) {
         System.out.println("Tốc độ tối đa: " + v.getMaxSpeed());
     }
 }
}

