package Inheritance.NeedForSpeed;

public class Vehicle {
    protected double defaultFuelConsumption ;
    protected double fuelConsumption;
    protected double fuel;
    protected int horsePower;

    public double getDefaultFuelConsumption() {
        return defaultFuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setDefaultFuelConsumption(double defaultFuelConsumption) {
        this.defaultFuelConsumption = defaultFuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.defaultFuelConsumption = fuelConsumption;
    }

    public void drive(double kilometers){
        if(kilometers * fuelConsumption <= fuel){
           fuel -= kilometers * fuelConsumption;
        }
    }



}
