package Polymorphism.VehiclesExtension;

public class Bus extends Vehicles {
    private static final double AIR_CONDITIONER = 1.4;

    protected Bus(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption, tankCapacity);
    }



    public String driveWithPeople(double distance)  {
        super.addCons(AIR_CONDITIONER);
        String out = super.drive(distance);
        super.removeCons(AIR_CONDITIONER);
        return out;
    }
}
