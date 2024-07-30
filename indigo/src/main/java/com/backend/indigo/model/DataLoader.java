package com.backend.indigo.model;


import com.backend.indigo.repository.FlightRepository;
import com.backend.indigo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void run(String... args) throws Exception {
        flightRepository.deleteAll();
        notificationRepository.deleteAll();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        Flight flight1 = new Flight();
        flight1.setId("1");
        flight1.setFlightId("6E 2341");
        flight1.setAirline("Indigo");
        flight1.setStatus("On Time");
        flight1.setDepartureGate("A12");
        flight1.setArrivalGate("B7");
        flight1.setScheduledDeparture(LocalDateTime.parse("2024-07-26T14:00:00Z", formatter));
        flight1.setScheduledArrival(LocalDateTime.parse("2024-07-26T18:00:00Z", formatter));
        flight1.setActualDeparture(null);
        flight1.setActualArrival(null);

        Flight flight2 = new Flight();
        flight2.setId("2");
        flight2.setFlightId("6E 2342");
        flight2.setAirline("Indigo");
        flight2.setStatus("Delayed");
        flight2.setDepartureGate("C3");
        flight2.setArrivalGate("D4");
        flight2.setScheduledDeparture(LocalDateTime.parse("2024-07-26T16:00:00Z", formatter));
        flight2.setScheduledArrival(LocalDateTime.parse("2024-07-26T20:00:00Z", formatter));
        flight2.setActualDeparture(null);
        flight2.setActualArrival(null);

        Flight flight3 = new Flight();
        flight3.setId("3");
        flight3.setFlightId("6E 2343");
        flight3.setAirline("Indigo");
        flight3.setStatus("Cancelled");
        flight3.setDepartureGate("E2");
        flight3.setArrivalGate("F1");
        flight3.setScheduledDeparture(LocalDateTime.parse("2024-07-26T12:00:00Z", formatter));
        flight3.setScheduledArrival(LocalDateTime.parse("2024-07-26T16:00:00Z", formatter));
        flight3.setActualDeparture(null);
        flight3.setActualArrival(null);

        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

        Notification notification1 = new Notification();
        notification1.setId("1");
        notification1.setFlightId("6E 2341");
        notification1.setMessage("Your flight 6E 2341 is on time. Departure gate: A12.");
        notification1.setTimestamp(LocalDateTime.parse("2024-07-26T13:00:00Z", formatter));
        notification1.setMethod("SMS");
        notification1.setRecipient("+1234567890");

        Notification notification2 = new Notification();
        notification2.setId("2");
        notification2.setFlightId("6E 2342");
        notification2.setMessage("Your flight 6E 2342 is delayed. New departure time: 2024-07-26T17:00:00Z. Departure gate: C3.");
        notification2.setTimestamp(LocalDateTime.parse("2024-07-26T15:30:00Z", formatter));
        notification2.setMethod("Email");
        notification2.setRecipient("user@example.com");

        Notification notification3 = new Notification();
        notification3.setId("3");
        notification3.setFlightId("6E 2343");
        notification3.setMessage("Your flight 6E 2343 has been cancelled.");
        notification3.setTimestamp(LocalDateTime.parse("2024-07-26T11:00:00Z", formatter));
        notification3.setMethod("App");
        notification3.setRecipient("user_app_id_12345");

        notificationRepository.saveAll(Arrays.asList(notification1, notification2, notification3));
    }
}
