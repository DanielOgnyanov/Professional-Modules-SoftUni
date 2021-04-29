package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerManagerTests {


    private ComputerManager computerManager;
    private Computer pc;
    private Computer pcTwo;



    @Before
    public void setUp() {
        computerManager = new ComputerManager();
        pc = new Computer("HP","Pavilion",1000);
        pcTwo = new Computer("Acer","Aspire",800);
    }


    @Test(expected = UnsupportedOperationException.class)

    public void testUnmodificableListException() {
        computerManager.getComputers().remove(0);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0,computerManager.getCount());
    }


    @Test (expected = IllegalArgumentException.class)

    public void testAddNull()  {
        computerManager.addComputer(null);
    }


    @Test(expected = IllegalArgumentException.class)

    public void testAddTwoTimeSamePc() {
        computerManager.addComputer(pc);
        computerManager.addComputer(pc);
    }


    @Test

    public void testAdd() {
        computerManager.addComputer(pc);
        Assert.assertEquals(1,computerManager.getCount());
    }


    @Test

    public void testRemove() {
        computerManager.addComputer(pc);
        computerManager.addComputer(pcTwo);
        computerManager.removeComputer("Acer","Aspire");
        Assert.assertEquals(1,computerManager.getCount());
    }


    @Test (expected = IllegalArgumentException.class)

    public void testGetPcExManu() {
        computerManager.getComputer(null,"Demo");

    }

    @Test (expected = IllegalArgumentException.class)

    public void testGetPcExModel() {
        computerManager.getComputer("Demo",null);

    }


    @Test (expected = IllegalArgumentException.class)

    public void testNotPresentPC() {
        computerManager.getComputer("Samsung","P1");

    }

    @Test

    public void testNormalGetPc() {
        computerManager.addComputer(pc);
        computerManager.getComputer("HP","Pavilion");
        Assert.assertEquals(pc,computerManager.getComputer("HP","Pavilion"));

    }


    @Test

    public void testGetPcByManu() {
        computerManager.addComputer(pc);
        computerManager.getComputersByManufacturer("HP");
        Assert.assertEquals(pc,computerManager.getComputersByManufacturer("HP").get(0));
    }



}