package Facade;

import java.sql.Date;

/**
 * Client can call Facade once to get the hotel and flight information
 */
public class Client{
    public static void main(String[] args)   {
        TravelFacade facade = new TravelFacade();
        facade.getFlightsAndHotels(Date.valueOf(args[0]), Date.valueOf(args[1]));
    }
}