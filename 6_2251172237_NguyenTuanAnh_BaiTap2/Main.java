package Btap2;
//Class cha
abstract class Vehicle {
 public abstract int getMaxSpeed();
}

//Class con car
class Car extends Vehicle {
 @Override
 public int getMaxSpeed() {
     return 200;
 }
}

//Class con bicycle
class Bicycle extends Vehicle {
 @Override
 public int getMaxSpeed() {
     return 30;
 }
}

//Liskov
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

