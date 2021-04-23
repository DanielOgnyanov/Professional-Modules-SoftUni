package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class BankVaultTest {
    private BankVault bankVault;
    private Item item;
    private Item two;

    @Before

    public void setUp() {
        bankVault = new BankVault();
        item = new Item("Dimo","1");
        two = new Item("Marto","2");


    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCollectionsSize() {
        bankVault.getVaultCells().remove("A1");
    }



    @Test(expected = IllegalArgumentException.class)
    public void testCellsIfExist() throws OperationNotSupportedException {
        bankVault.addItem("A5",item);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testTakenCell() throws OperationNotSupportedException {
        bankVault.addItem("A1",item);
        bankVault.addItem("A1",two);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDoubleItem() throws OperationNotSupportedException {
        bankVault.addItem("A1",item);
        bankVault.addItem("A2",item);
        Assert.assertTrue(bankVault.getVaultCells().containsValue(item));
    }


    @Test
    public void testAddMethod () throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        Assert.assertNotNull(bankVault.getVaultCells().get("A1"));

    }




    ////  Remove


    @Test
    public void testRemove() throws OperationNotSupportedException {
        bankVault.addItem("A1",item);
        bankVault.removeItem("A1",item);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));  ///
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNotEqualItem() throws OperationNotSupportedException {
        bankVault.addItem("A1",item);
        bankVault.addItem("A2",two);
        bankVault.removeItem("A1",two);

    }








    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCellNotExist()  {
        bankVault.removeItem("A10",item);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemNotExist()  {
        bankVault.removeItem("A2",item);
    }

    @Test

    public void testValidRemove() throws OperationNotSupportedException {
        bankVault.addItem("A1",item);
        
        Assert.assertEquals("Remove item:1 successfully!",bankVault.removeItem("A1",item));
    }


}