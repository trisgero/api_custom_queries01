package it.triexercise.API_Custom_Queries_01.controller;

import it.triexercise.API_Custom_Queries_01.entity.Flight;
import it.triexercise.API_Custom_Queries_01.entity.FlightStatus;
import it.triexercise.API_Custom_Queries_01.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    Random random = new Random();

    @Autowired
    FlightRepository flightRepository;

    /**
     * use "localhost:8080/flights/addFlights" to INSERT RANDOM FLIGHTS
     */
    @PostMapping("/addFlights")
    public void insert50Flights() {
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();

            String str = random.ints(48, 123)
                    .filter(num -> (num<58 || num>64) && (num<91 || num>96))
                    .limit(15)
                    .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
                    .toString();

            flight.setDescription(str);
            flight.setFromAirport(str);
            flight.setToAirport(str);
            flight.setStatus(FlightStatus.ON_TIME);
            flightRepository.save(flight);
        }
    }

    /**
     * use "localhost:8080/flights/getFlights" to GET ALL FLIGHTS
     * @return list of flights
     */
    @GetMapping("/getFlights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
