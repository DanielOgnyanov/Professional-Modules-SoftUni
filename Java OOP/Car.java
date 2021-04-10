package Polymorphism.Vehicles;

public class Car extends Vehicles {
    private static final double AIR_CONDITIONER = 0.9;

    public Car(double fuel, double consumption) {
        super(fuel, consumption + AIR_CONDITIONER);
    }
}
