package Polymorphism.VehiclesExtension;

public class Truck extends Vehicles {
    private static final double AIR_CONDITIONER = 1.6;

    protected Truck(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption + AIR_CONDITIONER, tankCapacity);
    }

    @Override
    public void refuel(double liters)  {
        super.refuel(liters * 0.95);
    }
}
