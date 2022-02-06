package designpatterns;
/*
    Factory Design Pattern :-
        1. Creational design pattern (i.e. related to creation of objects)
        2. Used when we have multiple subclass of super class & based on input
            we want to return one class instance
        3. Provides abstraction between implementation & client classes
        4. Remove instantiation of client classes from client code

        Implementation :-
            1. Super class can be interface or abstract class or basic class
            2. Factory class has a static method which returns the instance of subclass based on input.
 */

abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if(type == "car") {
            return new Car(wheel);
        } else if(type == "bike") {
            return new Bike(wheel);
        }

        return null;
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }

}
