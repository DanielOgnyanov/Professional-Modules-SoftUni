package onlineShop.models.products.computers;

import onlineShop.models.products.Computer;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;

public class BaseComputer extends Computer implements onlineShop.models.products.computers.Computer {


    private List<Component> components;
    private List<Peripheral> peripherals;


    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        List<Component> checkIfContainsTheSameType =
                this.components
                        .stream()
                        .filter(f -> f.getClass().getSimpleName().equals(component.getClass().getSimpleName()))
                .collect(Collectors.toList());

        if (checkIfContainsTheSameType.isEmpty()) {
            this.components.add(component);
        } else {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,component.getClass().getSimpleName(),
                    getClass().getSimpleName(),getId()));
        }
    }

    @Override
    public Component removeComponent(String componentType) {

        List<Component> resultOfCheckIfExist =
                this.components
                        .stream()
                        .filter(f -> f.getClass().getSimpleName().equals(componentType))
                .collect(Collectors.toList());

        if (resultOfCheckIfExist.isEmpty())  {
            throw new IllegalArgumentException
                    (String.format(NOT_EXISTING_COMPONENT,componentType,getClass().getSimpleName(),getId()));  /////
        } else {
            this.components.remove(resultOfCheckIfExist.get(0));
        }
        return resultOfCheckIfExist.get(0);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        List<Peripheral> checkIfContainsAlreadyTheElement =
                this.peripherals
                .stream()
                .filter(f -> f.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))
                .collect(Collectors.toList());

        if(checkIfContainsAlreadyTheElement.isEmpty())  {
            this.peripherals.add(peripheral);
        } else {
            throw new IllegalArgumentException
                    (String.format(EXISTING_PERIPHERAL,
                            peripheral.getClass().getSimpleName(),getClass().getSimpleName(),getId()));  ////
        }

    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        List<Peripheral> removeCheckToFindIfExist =
                this.peripherals
                .stream()
                .filter(f -> f.getClass().getSimpleName().equals(peripheralType))
                .collect(Collectors.toList());

        if(removeCheckToFindIfExist.isEmpty()) {
            throw new IllegalArgumentException
                    (String.format(NOT_EXISTING_PERIPHERAL,peripheralType,getClass().getSimpleName(),getId()));
        } else {
            this.peripherals.remove(removeCheckToFindIfExist.get(0));
        }
        return removeCheckToFindIfExist.get(0);
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double componentsAverage = 0;

        for (Component component : components) {
            componentsAverage += component.getOverallPerformance();
        }

        componentsAverage = componentsAverage / this.components.size();


        return super.getOverallPerformance() + componentsAverage;
    }


    @Override
    public double getPrice() {
        double allPriceComponent = 0;

        for (Component component : components) {
            allPriceComponent += component.getPrice();
        }

        double allPricePeripherals = 0;

        for (Peripheral peripheral : peripherals) {
            allPricePeripherals += peripheral.getPrice();
        }


        return super.getPrice() + allPriceComponent + allPricePeripherals;
    }



    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
               getOverallPerformance()
                ,getPrice()
                ,getClass().getSimpleName()
                ,getManufacturer()
                ,getModel()
                ,getId()))
                .append(System.lineSeparator())
                .append(String.format(" Components (%d):",getComponents().size()))
                .append(System.lineSeparator());


        for (Component component : components) {
            output.append("  " + component);
            output.append(System.lineSeparator());
        }

        double average = this.peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0);


        output.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",
                getPeripherals().size(),average))
                .append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            output.append("  " + peripheral);
        }


        return output.toString().trim();
    }
}
