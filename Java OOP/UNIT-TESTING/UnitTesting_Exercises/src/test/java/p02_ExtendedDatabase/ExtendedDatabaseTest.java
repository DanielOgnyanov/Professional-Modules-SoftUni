package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1,"First"),new Person(2,"Second"),
            new Person(3,"Third")};

    @Before
    public void prepareData() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }
    @Test
    public  void testConstructorIfCreateTheRightObject() throws OperationNotSupportedException {

       Person[] databaseNumbers = database.getElements();

        Assert.assertEquals("Count is not equals", PEOPLE.length,databaseNumbers.length);
        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(PEOPLE[i],databaseNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class )
    public void testConstructorIfThrowExceptionMoreThanSixteenElement() throws OperationNotSupportedException {
        Person[] num = new Person[17];
        new Database(num);
    }


    @Test(expected = OperationNotSupportedException.class )
    public void testConstructorIfThrowExceptionMinThanOneNumPresent() throws OperationNotSupportedException {
        Person[] num = new Person[0];
        new Database(num);
    }

    @Test(expected = OperationNotSupportedException.class )
    public void testAddIfThrowExceptionWhenAddingNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddIfAddInRightPosition() throws OperationNotSupportedException {
        database.add(new Person(4,"Demo"));
        Assert.assertEquals(4,database.getElements().length);
        Assert.assertEquals(4,database.getElements()[3].getId());
        Assert.assertEquals("Demo",database.getElements()[3].getUsername());

    }

    @Test(expected = OperationNotSupportedException.class )
    public void testRemoveMethodException() throws OperationNotSupportedException {
        Person[] PEOPLE = {};
        Database database = new Database(PEOPLE);
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(2,database.getElements().length);

    }


    @Test

    public  void testReturnCorrectPerson() throws OperationNotSupportedException {
        Person result = database.findByUsername("First");
        Assert.assertEquals(1,result.getId());
        Assert.assertEquals("First",result.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)

    public void testFindByUserAndReturnException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)

    public void testFindByUserAndThrowException() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername(null);
    }


    @Test(expected = OperationNotSupportedException.class)

    public void testFindByUserEmpty() throws OperationNotSupportedException {
        database = new Database(null,null);
        database.findByUsername("First");
    }

    @Test

    public  void testFindById() throws OperationNotSupportedException {
        Person result = database.findById(1);
        Assert.assertEquals(1,result.getId());
        Assert.assertEquals("First",result.getUsername());
    }


    @Test(expected = OperationNotSupportedException.class)

    public void testFindByIdAndThrowException() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }


    @Test(expected = OperationNotSupportedException.class)

    public void testFindByIdEmpty() throws OperationNotSupportedException {
        database = new Database(null,null);
        database.findById(1);
    }

}
