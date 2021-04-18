package p01_DatabaseTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest_Problem_1 {
    private Database database;
    private static final Integer[] NUMBERS = {17,23,5,7};

    @Before
    public void prepareData() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }
    @Test
    public  void testConstructorIfCreateTheRightObject() throws OperationNotSupportedException {

        Integer[] databaseNumbers = database.getElements();

        Assert.assertEquals("Count is not equals",NUMBERS.length,databaseNumbers.length);
        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(NUMBERS[i],databaseNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class )
    public void testConstructorIfThrowExceptionMoreThanSixteenElement() throws OperationNotSupportedException {
        Integer[] num = new Integer[17];
        new Database(num);
    }


    @Test(expected = OperationNotSupportedException.class )
    public void testConstructorIfThrowExceptionMinThanOneNumPresent() throws OperationNotSupportedException {
        Integer[] num = new Integer[0];
        new Database(num);
    }

    @Test(expected = OperationNotSupportedException.class )
    public void testAddIfThrowExceptionWhenAddingNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddIfAddInRightPosition() throws OperationNotSupportedException {
        database.add(17);
        Assert.assertEquals(5,database.getElements().length);
        Assert.assertEquals(Integer.valueOf(17),database.getElements()[4]);

    }

    @Test(expected = OperationNotSupportedException.class )
    public void testRemoveMethodException() throws OperationNotSupportedException {
        Integer[] numbers = {};
        Database database = new Database(numbers);
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(3,database.getElements().length);

    }
}
