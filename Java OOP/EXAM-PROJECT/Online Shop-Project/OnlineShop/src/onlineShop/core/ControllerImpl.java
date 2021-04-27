package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    Map<Integer , Computer> allComputers;
    Map<Integer , Component> componentMap;
    Map<Integer , Peripheral> peripheralMap;


    public ControllerImpl() {
        this.allComputers = new LinkedHashMap<>();
        this.componentMap = new LinkedHashMap<>();
        this.peripheralMap = new LinkedHashMap<>();
    }



    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;

        if(allComputers.containsKey(id))  {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }


        switch (computerType) {

            case "DesktopComputer":
                computer = new DesktopComputer(id,manufacturer,model,price);
                allComputers.put(id,computer);

                break;


            case "Laptop":
                computer = new Laptop(id,manufacturer,model,price);
                allComputers.put(id,computer);
                break;

            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);

        }
        return String.format(ADDED_COMPUTER,id);
    }




    @Override
    public String addPeripheral
            (int computerId, int id, String peripheralType, String manufacturer,
             String model, double price, double overallPerformance, String connectionType) {
        Peripheral peripheralToAdd;
        Computer updatedComputerPiace;

        if(peripheralMap.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }


        switch (peripheralType) {

            case "Headset":
                peripheralToAdd = new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
                peripheralMap.put(id,peripheralToAdd);
                updatedComputerPiace = allComputers.get(computerId);
                updatedComputerPiace.addPeripheral(peripheralToAdd);
                allComputers.put(computerId,updatedComputerPiace);
                break;


            case "keyboard":
                peripheralToAdd = new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
                peripheralMap.put(id,peripheralToAdd);
                updatedComputerPiace = allComputers.get(computerId);
                updatedComputerPiace.addPeripheral(peripheralToAdd);
                allComputers.put(computerId,updatedComputerPiace);
                break;


            case "Monitor":
                peripheralToAdd = new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
                peripheralMap.put(id,peripheralToAdd);
                updatedComputerPiace = allComputers.get(computerId);
                updatedComputerPiace.addPeripheral(peripheralToAdd);
                allComputers.put(computerId,updatedComputerPiace);
                break;

            case "Mouse":
                peripheralToAdd = new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);
                peripheralMap.put(id,peripheralToAdd);
                updatedComputerPiace = allComputers.get(computerId);
                updatedComputerPiace.addPeripheral(peripheralToAdd);
                allComputers.put(computerId,updatedComputerPiace);
                break;

            default:

                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }



        return String.format(ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer findPcInTheMap = allComputers.get(computerId);

        return String.format(REMOVED_PERIPHERAL,peripheralType,findPcInTheMap.removePeripheral(peripheralType).getId());
    }

    @Override
    public String addComponent
            (int computerId, int id, String componentType, String manufacturer,
             String model, double price, double overallPerformance, int generation) {

        Component addComponent;

        if(componentMap.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }


        switch (componentType) {

            case "CentralProcessingUnit":
                addComponent = new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
                componentMap.put(id,addComponent);
                Computer computer = allComputers.get(computerId);
                computer.addComponent(addComponent);
                allComputers.put(computerId,computer);

                break;

            case "Motherboard":
                addComponent = new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
                componentMap.put(id,addComponent);
                computer = allComputers.get(computerId);
                computer.addComponent(addComponent);
                allComputers.put(computerId,computer);
                break;


            case "PowerSupply":
                addComponent = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
                componentMap.put(id,addComponent);
                computer = allComputers.get(computerId);
                computer.addComponent(addComponent);
                allComputers.put(computerId,computer);
                break;


            case "RandomAccessMemory":
                addComponent = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
                componentMap.put(id,addComponent);
                computer = allComputers.get(computerId);
                computer.addComponent(addComponent);
                allComputers.put(computerId,computer);
                break;


            case "SolidStateDrive":
                addComponent = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
                componentMap.put(id,addComponent);
                computer = allComputers.get(computerId);
                computer.addComponent(addComponent);
                allComputers.put(computerId,computer);
                break;


            case "VideoCard":
                addComponent = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
                componentMap.put(id,addComponent);
                computer = allComputers.get(computerId);
                computer.addComponent(addComponent);
                allComputers.put(computerId,computer);
                break;

            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }


        return String.format(ADDED_COMPONENT,componentType,id,computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer findThePcInTheMap = allComputers.get(computerId);  ///////////////

        return String.format(REMOVED_COMPONENT,componentType,findThePcInTheMap.removeComponent(componentType).getId());
    }

    @Override
    public String buyComputer(int id) {
        if(!allComputers.containsKey(id)){
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return allComputers.remove(id).toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> result = new ArrayList<>();
        for (Computer value : allComputers.values()) {

            if (value.getPrice() <= budget) {
                result.add(value);
            }
        }

        if (result.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }

        double maxOveral = 0;
        for (Computer computer : result) {
            if (computer.getOverallPerformance() >= maxOveral)  {
                maxOveral = computer.getOverallPerformance();
            }
        }

        List<Computer> pcWithHighOveral = new ArrayList<>();

        for (Computer findPc : result) {
            if (findPc.getOverallPerformance() == maxOveral) {
                pcWithHighOveral.add(findPc);
            }
        }
        allComputers.remove(pcWithHighOveral.get(0).getId());

        return pcWithHighOveral.get(0).toString();
    }

    @Override
    public String getComputerData(int id) {
        if(!allComputers.containsKey(id)){
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return allComputers.get(id).toString();
    }
}
