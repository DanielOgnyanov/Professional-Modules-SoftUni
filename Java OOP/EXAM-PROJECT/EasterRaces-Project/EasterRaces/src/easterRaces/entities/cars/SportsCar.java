package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar implements Car {
    private static final int CUBIC_CENTIMETERS = 3000;

    private int horsePower;

    public SportsCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower, cubicCentimeters);
        this.setHorsePower(horsePower);
    }
    public void setHorsePower(int horsePower) {
        if (horsePower >= 250 && horsePower <= 450)  {    ///////// proveri dali 250 i 450 vliuchitelno ili ne
            this.horsePower = horsePower;
        } else  {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
    }

}
