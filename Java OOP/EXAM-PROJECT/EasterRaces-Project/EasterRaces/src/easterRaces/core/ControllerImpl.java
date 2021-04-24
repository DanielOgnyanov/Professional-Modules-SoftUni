package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Car> carRepo;
    private Repository<Race> raceRepo;
    private Repository<Driver> driverRepo;

    public ControllerImpl(Repository<Car> carRepo, Repository<Race> raceRepo ,Repository<Driver> driverRepo) {
        this.carRepo = new CarRepository<>();
        this.raceRepo = new RaceRepository<>();
        this.driverRepo = new DriverRepository<>();
    }


    @Override
    public String createDriver(String driver) {
        Driver driverToAdd;
        List<Driver> checkIfDriverIsAlreadyPresent = new ArrayList<>();

        checkIfDriverIsAlreadyPresent = driverRepo.getAll().stream().filter(f -> f.getName().equals(driver))
                .collect(Collectors.toList());

        if (checkIfDriverIsAlreadyPresent.isEmpty()) {
            driverToAdd = new DriverImpl(driver);
            driverRepo.add(driverToAdd);
        } else {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car carToAdd;

        List<Car> findIfCarAlreadyExist = new ArrayList<>();

        findIfCarAlreadyExist = carRepo.getAll().stream().filter(f -> f.getModel().equals(model))
                .collect(Collectors.toList());

        if (!findIfCarAlreadyExist.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        switch (type) {
            case "Muscle":

                carToAdd = new MuscleCar(model, horsePower, 5000);
                carRepo.add(carToAdd);
                type = "MuscleCar";
                break;

            case "Sports":

                carToAdd = new SportsCar(model,horsePower,3000);
                carRepo.add(carToAdd);
                type = "SportsCar";
                break;
        }
        return String.format(CAR_CREATED,type,model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver setCarToDriver;
        Car carToSet;

        List<Driver> driverToFind = this.driverRepo.getAll().stream().filter(f -> f.getName().equals(driverName))
                .collect(Collectors.toList());

        if(driverToFind.isEmpty()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }


        List<Car> carToFind = this.carRepo.getAll().stream().filter(f -> f.getModel().equals(carModel))
                .collect(Collectors.toList());

        if (carToFind.isEmpty()){
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND,carModel));
        }


        driverToFind.get(0).addCar(carToFind.get(0));
        return String.format(CAR_ADDED,driverName,carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race raceToFind;
        Driver driverToFind;

        List<Race> racesCheckIfIsPresent = this.raceRepo.getAll().stream().filter(f -> f.getName().equals(raceName))
                .collect(Collectors.toList());

        if(racesCheckIfIsPresent.isEmpty())  {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }


        List<Driver> driversToCheckIfExist = this.driverRepo.getAll().stream().filter(f -> f.getName().equals(driverName))
                .collect(Collectors.toList());


        if (driversToCheckIfExist.isEmpty()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }


        racesCheckIfIsPresent.get(0).addDriver(driversToCheckIfExist.get(0));
        return String.format(DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race raceToFindIfExist;
        Driver driverThatCanStartAnRace;

        List<Race> racesToCheck = this.raceRepo.getAll().stream().filter(f -> f.getName().equals(raceName))
        .collect(Collectors.toList());

        if (racesToCheck.isEmpty()) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }

        List<Driver> checkTheDriverIfIsMoreThan3 =
                this.driverRepo
                        .getAll()
                        .stream()
                        .filter(Driver::getCanParticipate)
                .collect(Collectors.toList());

        if(checkTheDriverIfIsMoreThan3.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        List<Race> findTheLapsInSpecificRace =
                this.raceRepo
                        .getAll()
                        .stream()
                        .filter(f -> f.getName().equals(raceName))
                .collect(Collectors.toList());


        List<Driver> sortDriverByMethodRacePointInCar =
                this.driverRepo
                .getAll()
                .stream()
                .sorted((f, s ) -> {

                    if (s.getCar().calculateRacePoints(findTheLapsInSpecificRace.get(0).getLaps())
                    > f.getCar().calculateRacePoints(findTheLapsInSpecificRace.get(0).getLaps())) {
                        return (int) f.getCar().calculateRacePoints(findTheLapsInSpecificRace.get(0).getLaps());
                    } else {
                        return (int) s.getCar().calculateRacePoints(findTheLapsInSpecificRace.get(0).getLaps());
                    }

                }).collect(Collectors.toList());

        Map<String, Double> allDriversResult = new LinkedHashMap<>();

        for (Driver driver : sortDriverByMethodRacePointInCar) {
            allDriversResult.put(driver.getName(),driver.getCar().calculateRacePoints(findTheLapsInSpecificRace.get(0).getLaps()));
        }


        StringBuilder output = new StringBuilder();

        List<Map.Entry<String, Double>> top3Drivers = allDriversResult
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());

        output.append(String.format(DRIVER_FIRST_POSITION,top3Drivers.get(0).getKey(),raceName))
                .append(System.lineSeparator())
                .append(String.format(DRIVER_SECOND_POSITION,top3Drivers.get(1).getKey(),raceName))
                .append(System.lineSeparator())
                .append(String.format(DRIVER_THIRD_POSITION,top3Drivers.get(2).getKey(),raceName));


        return output.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race raceToCreate;

        List<Race> raceToFindIfAlreadyExist = this.raceRepo.getAll().stream().filter(f -> f.getName().equals(name))
                .collect(Collectors.toList());

        if (!raceToFindIfAlreadyExist.isEmpty()) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
        }

        raceToCreate = new RaceImpl(name,laps);
        this.raceRepo.add(raceToCreate);

        return String.format(RACE_CREATED,name);
    }
}
