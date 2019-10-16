package Facade;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Treat Facade as Agent of subsystems. Each subsystem has only ONE actor it should be responsible for.
 * Subsystems may share same raw data, but they process data separately and return different results.
 * Considering an Company Employee class, we can have a facade including multiple subsystems to handle different processes
 * based on its raw data.
 * Each process is a module (Class and functions). For example, Classes: PayCalculator, HourReporter, EmployeeSaver.
 * Each class have a dedicate function (composed of a public method and couple of private methods). And in the
 * Facade, we have the instances of each subsystem.
 */
public class TravelFacade {
    private HotelBooker hotelBooker;
    private FlightBooker flightBooker;

    public void getFlightsAndHotels(Date from, Date to)  {
        ArrayList<Flight> flights = flightBooker.getFlightsFor(from, to);
        ArrayList<Hotel> hotels = hotelBooker.getHotelsFor(from, to);
        //process and return
    }

    public static void main(String... args) {
        for (int year=2018; year<2050; year++) {
            for (int month=1; month<=12; month++) {
                LocalDate date = LocalDate.of(year, month, 16);
                DayOfWeek dayOfWeek = date.getDayOfWeek();
                if (dayOfWeek.equals(DayOfWeek.MONDAY)) {
                    System.out.println(year + " " + month + " 16");
                }
            }
        }
    }
}
