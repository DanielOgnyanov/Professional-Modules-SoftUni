package Polymorphism.VehiclesExtension;

public class Car extends Vehicles {
    private static final double AIR_CONDITIONER = 0.9;


    protected Car(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption, tankCapacity);
    }
}
