package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {

    private Player player;
    private Player playerTwo;
    private Gun gunOne;

    @Before

    public void setUp() {
        player = new Player("Marto",100);
        gunOne = new Gun("Pistol",10);
    }


    @Test

    public void testAddNormal() {
        player.addGun(gunOne);
        Assert.assertEquals(gunOne,player.getGun("Pistol"));

    }


    @Test(expected = NullPointerException.class)

    public void testAddEx() {
        player.addGun(null);
    }

    @Test

    public void testRemove() {
        player.addGun(gunOne);
        player.removeGun(gunOne);
        Assert.assertEquals(0,player.getGuns().size());

    }

    @Test

    public void testGetGun() {
        player.addGun(gunOne);
        Assert.assertEquals(gunOne,player.getGun("Pistol"));
    }

    @Test(expected = IllegalStateException.class)

    public void testTakeDamageEx() {
        player.takeDamage(100);
        player.takeDamage(10);
    }

    @Test

    public void testNormalTakeDamage()  {
        player.takeDamage(80);
        Assert.assertEquals(20,player.getHealth());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodificableList() {
        player.getGuns().remove(0);
    }

    @Test

    public void testGetHel() {
        int health = player.getHealth();

        Assert.assertEquals(100,health);
    }


    @Test

    public void testGetUser() {
        String username = player.getUsername();
        Assert.assertEquals("Marto",username);
    }


    @Test(expected = NullPointerException.class)

    public void testSetName() {
        playerTwo = new Player(null,20);

    }



}
