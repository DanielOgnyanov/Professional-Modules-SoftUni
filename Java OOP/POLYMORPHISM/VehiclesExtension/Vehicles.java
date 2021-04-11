package Polymorphism.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicles {
    private double fuel;
    private double consumption;
    private double tankCapacity;


    protected Vehicles(double fuel, double consumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuel);
        this.consumption = consumption;

    }

    private void setFuel(double fuel) {
        validateFuel(fuel);
        validateTankCapacity(fuel);
        this.fuel = fuel;
    }

    protected void  addCons(double add)  {
        this.consumption += add;
    }

    protected void  removeCons(double remove)  {
        this.consumption -= remove;
    }


    private void validateFuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateTankCapacity(double fuel) {
        if (fuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.consumption;

        if (fuelNeeded > this.fuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.setFuel(this.fuel - fuelNeeded);

        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(distance));
    }


    public void refuel(double liters) {
        validateFuel(liters);
        validateTankCapacity(liters);
        this.setFuel(this.fuel + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
