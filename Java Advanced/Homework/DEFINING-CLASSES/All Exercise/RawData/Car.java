package DefiningClasses.RawData;

public class Car {


    public Car(String model,
               String engineSpeed,
               int enginePower,
               String cargoWeight,
               String cargoType,
               double tireOnePressure,
               double tireTwoPressure,
               double tireThreePressure,
               double tireFourPressure) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tireOnePressure = tireOnePressure;
        this.tireTwoPressure = tireTwoPressure;
        this.tireThreePressure = tireThreePressure;
        this.tireFourPressure = tireFourPressure;
    }

    public String getModel() {
        return model;
    }

    public String getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTireOnePressure() {
        return tireOnePressure;
    }

    public double getTireTwoPressure() {
        return tireTwoPressure;
    }

    public double getTireThreePressure() {
        return tireThreePressure;
    }

    public double getTireFourPressure() {
        return tireFourPressure;
    }

    String model;
    String engineSpeed;
    int enginePower;
    String cargoWeight;
    String cargoType;

    double tireOnePressure;
    double tireTwoPressure;
    double tireThreePressure;
    double tireFourPressure;


}
