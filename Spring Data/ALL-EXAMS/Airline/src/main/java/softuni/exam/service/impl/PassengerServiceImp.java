package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.jsons.PassengersImportDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


@Service
public class PassengerServiceImp implements PassengerService {

    private static final String PASSENGERS_PATH = "src/main/resources/files/json/passengers.json";


    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;
    private final TicketRepository ticketRepository;

    public PassengerServiceImp(PassengerRepository passengerRepository,
                               ModelMapper modelMapper, Gson gson,
                               ValidationUtil validationUtil, TownRepository townRepository, TicketRepository ticketRepository) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
        this.ticketRepository = ticketRepository;
    }


    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(PASSENGERS_PATH)));
    }

    @Override
    public String importPassengers() throws IOException {

        StringBuilder sb = new StringBuilder();


        PassengersImportDto[] passengersImportDtos =
                this.gson.fromJson(this.readPassengersFileContent(), PassengersImportDto[].class);


        for (PassengersImportDto currPassenger : passengersImportDtos) {

            Optional<Town> byNameTown = this.townRepository.findByName(currPassenger.getTown());

            boolean valid = this.validationUtil.isValid(currPassenger);

            if (valid && byNameTown.isPresent()) {

                Passenger passenger = this.modelMapper.map(currPassenger, Passenger.class);

                passenger.setTown(byNameTown.get());

                this.passengerRepository.saveAndFlush(passenger);

                sb
                        .append(String.format("Successfully imported Passenger %s - %s",
                                currPassenger.getLastName(), currPassenger.getEmail()))
                        .append(System.lineSeparator());


            } else {
                sb.append("Invalid Passenger").append(System.lineSeparator());
            }


        }


        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        StringBuilder sb = new StringBuilder();


        List<Passenger> toPrint = this.passengerRepository.result();


        for (Passenger curr : toPrint) {

            sb.append(String.format("Passenger %s %s", curr.getFirstName(),
                    curr.getLastName()))
                    .append(System.lineSeparator())
                    .append(String.format("Email - %s", curr.getEmail()))
                    .append(System.lineSeparator())
                    .append(String.format("Phone - %s", curr.getPhoneNUmber()))
                    .append(System.lineSeparator())
                    .append(String.format("Number of tickets: %s", curr.getTicketSet().size()))
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
