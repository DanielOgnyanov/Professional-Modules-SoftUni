package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private Garage garage;
    private Car car;
    private Car carTwo;


    @Before
    public void setGarage()  {
        garage = new Garage();
        car = new Car("Audi",340,180000);
        carTwo = new Car("Mercedes",280,200000);
    }


    @Test(expected = UnsupportedOperationException.class)

    public void testGetCarsMethodException() {
        garage.addCar(car);
        garage.getCars().remove(0);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0,garage.getCount());
    }



    @Test

    public void testMaxSpeed() {
        garage.addCar(car);
        garage.addCar(carTwo);
        List<Car> result = garage.findAllCarsWithMaxSpeedAbove(300);
        Assert.assertEquals(car,result.get(0));
    }


    @Test

    public void testNormalAdd() {
        garage.addCar(car);
        Car result = garage.getCars().get(0);
        Assert.assertEquals(car,result);
    }


    @Test(expected = IllegalArgumentException.class)

    public void testExceptionAdd(){
        garage.addCar(null);
    }



    @Test

    public void testMostExpensiveCar() {
        garage.addCar(car);
        garage.addCar(carTwo);
        Car result = garage.getTheMostExpensiveCar();
        Assert.assertEquals(carTwo,result);
    }


    @Test

    public void testFindCarByBrand() {
        garage.addCar(car);
        garage.addCar(carTwo);
        List<Car> result = garage.findAllCarsByBrand("Audi");
        Assert.assertEquals(car,result.get(0));
    }








}