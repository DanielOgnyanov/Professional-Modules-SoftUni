package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.xmls.TicketImportDto;
import softuni.exam.models.dtos.xmls.TicketImportRootDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Service
public class TicketServiceImp implements TicketService {


    private static final String TICKET_PATH = "src/main/resources/files/xml/tickets.xml";

    private final PlaneRepository planeRepository;
    private final TownRepository townRepository;
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public TicketServiceImp(PlaneRepository planeRepository,
                            TownRepository townRepository,
                            PassengerRepository passengerRepository,
                            TicketRepository ticketRepository,
                            ModelMapper modelMapper,
                            XmlParser xmlParser,
                            ValidationUtil validationUtil) {
        this.planeRepository = planeRepository;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(TICKET_PATH)));
    }

    @Override
    public String importTickets() throws JAXBException {

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        TicketImportRootDto ticketImportRootDto =
                this.xmlParser.parseXml(TicketImportRootDto.class, TICKET_PATH);



        for (TicketImportDto currTicket : ticketImportRootDto.getTicketImportDto()) {


            Optional<Town> fromTownCheck =
                    this.townRepository.findByName(currTicket.getFromTown().getName());

            Optional<Town> toTownCheck =
                    this.townRepository.findByName(currTicket.getToTown().getName());

            Optional<Passenger> emailCheck =
                    this.passengerRepository.findByEmail(currTicket.getPassengerEmail().getEmail());

            String demo = currTicket.getPlaneRegisterNumber().getRegisterNumber();
            Optional<Plane> registerNumberCheck =
                    this.planeRepository.findByRegisterNumber(currTicket.getPlaneRegisterNumber().getRegisterNumber());


            if (this.validationUtil.isValid(currTicket) && fromTownCheck.isPresent()
                    && toTownCheck.isPresent() && emailCheck.isPresent() && registerNumberCheck.isPresent()) {


                Ticket ticket = this.modelMapper.map(currTicket, Ticket.class);

                LocalDateTime localDateTime = LocalDateTime.parse(currTicket.getTakeoff(), dtf);

                ticket.setTakeoff(localDateTime);
                ticket.setFromTown(fromTownCheck.get());
                ticket.setToTown(toTownCheck.get());
                ticket.setPassenger(emailCheck.get());
                ticket.setPlane(registerNumberCheck.get());

                this.ticketRepository.saveAndFlush(ticket);

                sb.append(String.format("Successfully imported Ticket %s - %s", currTicket.getFromTown().getName(),
                        currTicket.getToTown().getName()))
                        .append(System.lineSeparator());

            } else {

                sb.append("Invalid Ticket").append(System.lineSeparator());

            }


        }


        return sb.toString();
    }
}
