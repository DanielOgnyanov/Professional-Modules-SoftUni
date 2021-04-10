package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuel;
    private double consumption;


    protected Vehicles(double fuel, double consumption) {
        this.fuel = fuel;
        this.consumption = consumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.consumption;

        if (fuelNeeded > this.fuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuel -= fuelNeeded;

        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(),format.format(distance));
    }


    public void refuel(double liters) {
        this.fuel += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName() ,this.fuel);
    }
}
