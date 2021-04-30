package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerImpl implements Player {


    private String username;
    private int health;
    private int armor;
    private boolean isAlive = true;
    private Gun gun;


    public PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }


    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setGun(Gun gun) {
        if (gun == null)  {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (points <= this.armor) {
            this.armor = this.armor - points;
        } else {

            points = points - this.armor;
            this.armor = 0;
            if (points < health) {
                this.health = this.health - points;
            } else {
                points = points - this.health;
                this.health = 0;
                setAlive(false);
            }

        }

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%s: %s", this.getClass().getSimpleName(), getUsername()))
                .append(System.lineSeparator());
        output.append(String.format("--Health: %d", getHealth()))
                .append(System.lineSeparator());
        output.append(String.format("--Armor: %d", getArmor()))
                .append(System.lineSeparator());
        output.append(String.format("--Gun: %s", this.gun.getName()))
                .append(System.lineSeparator());

        return output.toString().trim();
    }
}
