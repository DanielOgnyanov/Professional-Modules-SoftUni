package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar implements Car {

    public static final int CUBIC_CENTIMETERS = 5000;
    private int horsePower;

    public MuscleCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower, cubicCentimeters);
        this.setHorsePower(horsePower); ////
    }

    public void setHorsePower(int horsePower) {
        if (horsePower >= 400 && horsePower <= 600)  {    ///////// proveri dali 400 i 600 vliuchitelno ili ne
            this.horsePower = horsePower;
        } else  {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }

    }
}
