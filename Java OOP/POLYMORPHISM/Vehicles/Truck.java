package Polymorphism.Vehicles;

public class Truck extends Vehicles {

    private static final double AIR_CONDITIONER = 1.6;

    public  Truck(double fuel, double consumption) {
        super(fuel, consumption + AIR_CONDITIONER);
    }


    @Override
    public void refuel(double liters)  {
        super.refuel(liters * 0.95);
    }
}
