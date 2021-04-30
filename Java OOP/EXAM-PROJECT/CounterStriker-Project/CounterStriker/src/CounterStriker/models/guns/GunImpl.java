package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_BULLETS_COUNT;
import static CounterStriker.common.ExceptionMessages.INVALID_GUN_NAME;

public class GunImpl implements Gun {

    private String name;
    private int bulletsCount;


    public GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }


    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if (bulletsCount <= 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }



    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        int result = 0;
        if (getName().equals("Pistol")) {
            if(getBulletsCount() < 1)  {
                return 0;
            }
             result = getBulletsCount() - 1;
        } else if (getName().equals("Rifle")) {
            if(getBulletsCount() < 10)  {
                return 0;
            }
             result = getBulletsCount() - 10;
        }
        return result;
    }
}
